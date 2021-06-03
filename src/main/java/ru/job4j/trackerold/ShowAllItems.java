package ru.job4j.trackerold;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

import java.util.List;

public class ShowAllItems implements UserAction {
    private final ru.job4j.tracker.Output out;

    public ShowAllItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Show all items ====");
        List<ru.job4j.tracker.Item> items = tracker.findAll();
        for (Item it : items) {
            out.println(it);
        }
        return true;
    }
}
