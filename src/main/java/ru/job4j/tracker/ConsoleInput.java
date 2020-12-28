package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public String askStr() {
        return this.scanner.nextLine();
    }

    @Override
    public int askInt() {
        return Integer.valueOf(this.scanner.nextLine());
    }
}
