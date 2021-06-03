package ru.job4j.trackerold;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

import java.util.List;

public class FindItemByName implements UserAction {
    private final ru.job4j.tracker.Output out;

    public FindItemByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Find items by name ====");
        String name = input.askStr("Enter name: ");
        List<ru.job4j.tracker.Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item it : items) {
                out.println(it);
            }
        } else {
            out.println("Заявки с таким именем не найдены.");
        }
        return true;
    }
}
