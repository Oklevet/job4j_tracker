package ru.job4j.tracker;

public class ReplaceItem implements UserAction {
    private final Output out;

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
        Item item = new Item(input.askStr("Enter new name for Item: "));
        int id = input.askInt("Enter id: ");
        if (tracker.replace(id, item)) {
            out.println("Edit item is done.");
        } else {
            out.println(String.format("Item with id=%s not found.", id));
        }
        return true;
    }
}
