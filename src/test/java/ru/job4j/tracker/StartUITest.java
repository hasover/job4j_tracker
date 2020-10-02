package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction action = new CreateAction();
        action.execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenAddItem2() {
        String[] answers = {"Update program"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction action = new CreateAction();
        action.execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Update program");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        String[] answers = {"1", "Update program"};
        Tracker tracker = new Tracker();
        Input input = new StubInput(answers);
        UserAction action = new EditAction();
        Item item = new Item("Fix PC");
        tracker.add(item);
        action.execute(input, tracker);
        assertThat(tracker.findAll()[0].getName(), is("Update program"));
    }

    @Test
    public void whenDeleteItem() {
        String[] answers = {"1"};
        Tracker tracker = new Tracker();
        Input input = new StubInput(answers);
        UserAction action = new DeleteAction();
        Item item = new Item("Fix PC");
        tracker.add(item);
        action.execute(input, tracker);
        assertThat(tracker.findById(1), is((Item)null));
    }
}