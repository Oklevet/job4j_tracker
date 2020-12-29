package ru.job4j.tracker;

public class FindItemByName implements UserAction {
    @Override
    public String name() {
        return "Find items by name.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if(items.length > 0) {
            for (Item it : items) {
                System.out.println(it);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены.");
        }
        return true;
    }
}
