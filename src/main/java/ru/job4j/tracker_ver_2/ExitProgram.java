package ru.job4j.tracker_ver_2;

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
