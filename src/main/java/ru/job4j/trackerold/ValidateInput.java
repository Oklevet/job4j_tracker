package ru.job4j.trackerold;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;

public class ValidateInput implements ru.job4j.tracker.Input {
    private final ru.job4j.tracker.Output out;
    private final ru.job4j.tracker.Input in;

    public ValidateInput(Output out, Input input) {
        this.out = out;
        this.in = input;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = in.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
