package ru.job4j.sort.tracker2;

public class ExitProgram implements UserAction {

    @Override
    public String name() {
        return "Exit.";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        return false;
    }
}
