package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        List<Item> result = new ArrayList<>();
        List<Item> expected = new ArrayList<>();
        item.setName("test1");
        item.setId(1);
        tracker.add(item);
        result = tracker.findByName("test1");
        expected.add(item);
        assertThat(result.get(0).getId(), is(expected.get(0).getId()));
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
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item2);
        List<Item> result = tracker.findAll();
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

    @Test
    public void whenUpItemCompare() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("cqwe");
        Item item2 = new Item("aqwe");
        Item item3 = new Item("bqwe");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> items = new ArrayList<>();
        List<Item> expected = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        expected.add(item2);
        expected.add(item3);
        expected.add(item1);
        Comparator upCompar = new ItemsUpComparator();
        Collections.sort(items, upCompar);
        assertThat(items, is(expected));
    }

    @Test
    public void whenDownItemCompare() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("cqwe");
        Item item2 = new Item("aqwe");
        Item item3 = new Item("bqwe");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> items = new ArrayList<>();
        List<Item> expected = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        expected.add(item1);
        expected.add(item3);
        expected.add(item2);
        Comparator upCompar = new ItemsDownComparator();
        Collections.sort(items, upCompar);
        assertThat(items, is(expected));
    }
}