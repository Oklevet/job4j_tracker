package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public String name() {
        return "Delete item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        if(tracker.delete(id)) {
            System.out.println("Удаление заявки произведено.");
        } else {
            System.out.println("Заявка с таким id не найдена.");
        }
        return true;
    }
}
