package ru.job4j.sort.tracker2;

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
    public boolean execute(Input input, Store tracker) {
        out.println("==== Edit item ====");
        Item item = new Item(input.askStr("Enter name: "));
        int id = input.askInt("Enter id: ");
        if (tracker.replace(id, item)) {
            out.println("Замена заявки произведена.");
        } else {
            out.println("Заявка с таким id не найдена.");
        }
        return true;
    }
}
