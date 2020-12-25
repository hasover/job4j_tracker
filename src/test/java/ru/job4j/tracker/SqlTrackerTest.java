package ru.job4j.tracker;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SqlTrackerTest {
    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().
                getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item(0, "desc"));
            assertThat(tracker.findByName("desc").size(), is(1));
        }
    }

    @Test
    public void replaceItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item addedItem = tracker.add(new Item(0, "desc"));
            tracker.replace(addedItem.getId(), new Item(0, "descNew"));
            assertThat(tracker.findById(addedItem.getId()).getName(), is("descNew"));
        }
    }

    @Test
    public void deleteItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item addedItem = tracker.add(new Item(0, "desc"));
            tracker.delete(addedItem.getId());
            assertThat(tracker.findById(addedItem.getId()), is(nullValue()));
        }
    }

    @Test
    public void findAllItems() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item addedItem1 = tracker.add(new Item(0, "desc1"));
            Item addedItem2 = tracker.add(new Item(0, "desc2"));
            assertThat(tracker.findAll(), is(List.of(addedItem1, addedItem2)));
        }
    }

}