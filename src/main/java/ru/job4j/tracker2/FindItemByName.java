package ru.job4j.tracker2;

import java.util.List;

public class FindItemByName implements UserAction {
    private final Output out;

    public FindItemByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name.";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("==== Find items by name ====");
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
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
