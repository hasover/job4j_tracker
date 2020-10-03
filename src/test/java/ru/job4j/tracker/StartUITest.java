package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", "" + item.getId(), replacedName, "1"}
        );
        Output out = new ConsoleOutput();
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[]{"0", "" + item.getId(), "1"}
        );
        Output out = new ConsoleOutput();
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0.Exit Program" + System.lineSeparator()));
    }

    @Test
    public void whenFindAllTest() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0","1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("A"));
        UserAction[] actions = {new ShowAllAction(out),new ExitAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0.Show all items" + System.lineSeparator() +
                "1.Exit Program" + System.lineSeparator()+
                "List of items:" + System.lineSeparator() +
                "Item{id=1, name='A'}" + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0.Show all items" + System.lineSeparator() +
                "1.Exit Program" + System.lineSeparator()));
    }

    @Test
    public void whenFindByNameTest() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0","Fix Pc", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("Fix Pc"));
        tracker.add(new Item("Fix Pc"));
        UserAction[] actions = {new FindByNameAction(out),new ExitAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0.Find items by name" + System.lineSeparator() +
                "1.Exit Program" + System.lineSeparator()+
                "List of items:" + System.lineSeparator() +
                "Item{id=1, name='Fix Pc'}" + System.lineSeparator() +
                "Item{id=2, name='Fix Pc'}" + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0.Find items by name" + System.lineSeparator() +
                "1.Exit Program" + System.lineSeparator()));
    }

    @Test
    public void whenFindByIdTest() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0","1", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("Fix Pc"));
        UserAction[] actions = {new FindByIdAction(out),new ExitAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0.Find item by Id" + System.lineSeparator() +
                "1.Exit Program" + System.lineSeparator()+
                "Item: Item{id=1, name='Fix Pc'}" + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0.Find item by Id" + System.lineSeparator() +
                "1.Exit Program" + System.lineSeparator()));
    }
}