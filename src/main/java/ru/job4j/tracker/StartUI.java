package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        System.out.print("Enter name: ");
        String name = input.askStr();
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] items = tracker.findAll();
        for (Item it : items) {
            System.out.println(it);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        System.out.print("Enter name: ");
        Item item = new Item(input.askStr());
        System.out.print("Enter id: ");
        int id = input.askInt();
        if (tracker.replace(id, item)) {
            System.out.println("Замена заявки произведена.");
        } else {
            System.out.println("Заявка с таким id не найдена.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        System.out.print("Enter id: ");
        int id = input.askInt();
        if(tracker.delete(id)) {
            System.out.println("Удаление заявки произведено.");
        } else {
            System.out.println("Заявка с таким id не найдена.");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        System.out.print("Enter id: ");
        int id = input.askInt();
        Item item = tracker.findById(id);
        if(item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с таким id не найдена.");
        }
    }

    public static void finItemsByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        System.out.print("Enter name: ");
        String name = input.askStr();
        Item[] items = tracker.findByName(name);
        if(items.length > 0) {
            for (Item it : items) {
                System.out.println(it);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены.");
        }
    }


    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = input.askInt();
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.finItemsByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
