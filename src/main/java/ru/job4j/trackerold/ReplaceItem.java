package ru.job4j.trackerold;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

public class ReplaceItem implements UserAction {
    private final ru.job4j.tracker.Output out;

    public ReplaceItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Edit item ====");
        ru.job4j.tracker.Item item = new Item(input.askStr("Enter name: "));
        int id = input.askInt("Enter id: ");
        if (tracker.replace(id, item)) {
            out.println("Замена заявки произведена.");
        } else {
            out.println("Заявка с таким id не найдена.");
        }
        return true;
    }
}
