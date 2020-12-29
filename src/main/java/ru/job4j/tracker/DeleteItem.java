package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Delete item ====");
        int id = input.askInt("Enter id: ");
        if(tracker.delete(id)) {
            System.out.println("Удаление заявки произведено.");
        } else {
            System.out.println("Заявка с таким id не найдена.");
        }
        return true;
    }
}
