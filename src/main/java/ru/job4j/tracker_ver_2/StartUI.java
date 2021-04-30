package ru.job4j.tracker_ver_2;

import java.util.List;

public class StartUI {
    private final Output out;
    private final List<UserAction> actions;
    private Store sqlTrack;

    public StartUI(Output out) {
        this.out = out;
        this.actions = List.of(new CreateAction(out), new ShowAllItems(out)
                ,new ReplaceItem(out), new DeleteItem(out), new FindItemById(out)
                ,new FindItemByName(out), new ExitProgram()
        );
        try {
            sqlTrack = new SqlTracker();
            sqlTrack.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(Input input) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = this.actions.get(select);
            run = action.execute(input, sqlTrack);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (UserAction act : actions) {
            out.println(actions.indexOf(act) + ". " + act.name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        new StartUI(output).init(input);
    }
}
