package ru.job4j.tracker_ver_2;

public class DeleteItem implements UserAction {
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item.";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("==== Delete item ====");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            out.println("Удаление заявки произведено.");
        } else {
            out.println("Заявка с таким id не найдена.");
        }
        return true;
    }
}
