package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StartUITest {

    @Test
    public void executeAdd() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceItem rep = new ReplaceItem(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("==== Edit item ====" + ln + "Edit item is done." + ln);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo(replacedName);
    }

    @Test
    public void executeFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("New item");
        tracker.add(item);
        FindItemById find = new FindItemById(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("==== Find item by Id ====" + ln + item + ln);
        assertThat(tracker.findById(1)).isEqualTo(item);
    }

    @Test
    public void executeFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("New item");
        tracker.add(item);
        List<Item> expectedList = new ArrayList<>();
        expectedList.add(item);
        FindItemByName find = new FindItemByName(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("New item");

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("==== Find items by name ====" + ln + item + ln);
        assertThat(tracker.findByName("New item")).isEqualTo(expectedList);
    }

    @Test
    public void executeFindByNameFewItems() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = new Item("item");
        Item item2 = new Item("item");
        tracker.add(item1);
        tracker.add(item2);
        List<Item> expectedList = new ArrayList<>();
        expectedList.add(item1);
        expectedList.add(item2);
        FindItemByName find = new FindItemByName(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("item");

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("==== Find items by name ====" + ln + item1 + ln + item2 + ln);
        assertThat(tracker.findByName("item")).isEqualTo(expectedList);
    }

    @Test
    public void executeDelete() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("New item"));
        DeleteItem del = new DeleteItem(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("==== Delete item ====" + ln + "Удаление заявки произведено." + ln);
        assertThat(tracker.findAll().size()).isLessThan(1);
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitProgram()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit." + System.lineSeparator()
        ));
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitProgram()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("qwe1"));
        Item[] items = new Item[] {item};
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowAllItems(out),
                new ExitProgram()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Show all items." + System.lineSeparator()
                        + "1. Exit." + System.lineSeparator()
                        + "==== Show all items ====" + System.lineSeparator()
                        + "Item{id=1, name='qwe1'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Show all items." + System.lineSeparator()
                        + "1. Exit." + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("qwe1"));
        String findName = "qwe1";
        Input in = new StubInput(
                new String[] {"0", "qwe1", "1"}
        );
        UserAction[] actions = {
                new FindItemByName(out),
                new ExitProgram()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find items by name." + System.lineSeparator()
                        + "1. Exit." + System.lineSeparator()
                        + "==== Find items by name ====" + System.lineSeparator()
                        + "Item{id=1, name='qwe1'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find items by name." + System.lineSeparator()
                        + "1. Exit." + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("qwe1"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new FindItemById(out),
                new ExitProgram()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find item by Id." + System.lineSeparator()
                        + "1. Exit." + System.lineSeparator()
                        + "==== Find item by Id ====" + System.lineSeparator()
                        + "Item{id=1, name='qwe1'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find item by Id." + System.lineSeparator()
                        + "1. Exit." + System.lineSeparator()
        ));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", "New item name", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new ReplaceItem(out),
                new ExitProgram()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteItem(out),
                new ExitProgram()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitProgram()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit.%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit.%n"
                )
        ));
    }
}