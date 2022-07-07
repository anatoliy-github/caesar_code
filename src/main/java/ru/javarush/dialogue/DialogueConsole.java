package ru.javarush.dialogue;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DialogueConsole implements Dialogue {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_RESET = "\u001B[0m";

    private static final String WELCOME =
            """
               *******************
               ***PROGRAM START***
               *******************
               """;

    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.print(ANSI_PURPLE + WELCOME + ANSI_RESET);
        displayMenu();
        Menu menu = getSelectedMenuItem();
        System.out.println("Selected " + menu);
    }

    private void displayMenu() {
        System.out.println(ANSI_GREEN + "Select program mode:" + ANSI_RESET);
        List<Menu> array = Arrays.asList(Menu.values());
        for (Menu item : array) {
            System.out.println(ANSI_GREEN + item.getOrder() + ANSI_RESET + " - " + item.getName());
        }
    }

    private Menu getSelectedMenuItem() {
        System.out.print(ANSI_GREEN + "Your choice: " + ANSI_RESET);
        int selectedMode = scanner.nextInt();
        return Menu.getMenuByNumber(selectedMode);
    }



}
