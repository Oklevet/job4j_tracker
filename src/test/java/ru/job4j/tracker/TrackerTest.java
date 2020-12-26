package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        item.setId(1);
        tracker.add(item);
        Item result = tracker.findById(1);
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenItemFindByName() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        Item[] result = new Item[1];
        Item[] expected = new Item[1];
        item.setName("test1");
        item.setId(1);
        tracker.add(item);
        result = tracker.findByName("test1");
        expected[0] = item;
        assertThat(result[0].getId(), is(expected[0].getId()));
    }

    @Test
    public void whenItemFindByAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        Item item2 = new Item();
        item1.setName("test1");
        item1.setId(1);
        item1.setName("test2");
        item1.setId(2);
        tracker.add(item1);
        tracker.add(item2);
        Item[] items = new Item[2];
        items[0] = item1;
        items[1] = item2;
        Item[] expected = new Item[2];
        expected[0] = item1;
        expected[1] = item2;
        Item[] result = tracker.findAll(items);
        assertThat(result, is(expected));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}