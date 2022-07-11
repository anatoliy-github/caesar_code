package ru.javarush.dialogue;

import ru.javarush.operation.Operation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DialogueConsole implements Dialogue {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_RESET = "\u001B[0m";

    private static final String WELCOME =
            """
               *******************
               ***PROGRAM START***
               *******************
               """;

    private final Scanner scanner = new Scanner(System.in);

    private Operation operation = new Operation();

    public void start() {
        System.out.print(ANSI_PURPLE + WELCOME + ANSI_RESET);
        displayMenu();
        selectOperation();
    }

    private void displayMenu() {
        System.out.println(ANSI_GREEN + "Select program mode:" + ANSI_RESET);
        List<Menu> array = Arrays.asList(Menu.values());
        for (Menu item : array) {
            System.out.println(ANSI_GREEN + item.ordinal() + ANSI_RESET + " - " + item.getName());
        }
    }

    private void selectOperation() {
        Menu menu = null;
        boolean tryAgain;
        do {
            try {
                System.out.print(ANSI_GREEN + "Your choice: " + ANSI_RESET);
                int selectedMode = Integer.parseInt(scanner.next());
                menu = Menu.getMenuByNumber(selectedMode);
                tryAgain = false;
            } catch (IllegalArgumentException e) {
                System.out.println(ANSI_RED + "Invalid choice. Try again" + ANSI_RESET);
                tryAgain = true;
            }
        } while(tryAgain);

        switch(menu.ordinal()) {
            case 0 -> System.out.println(ANSI_RED + "Exit" + ANSI_RESET);
            case 1 -> encryptionMode();
            case 2 -> decryptionMode();
            case 3 -> decryptionBruteForce();
        }
    }

    private void encryptionMode() {
        System.out.println(ANSI_BLUE + "The encryption mode is selected" + ANSI_RESET);
        System.out.print("Enter path to file: ");
        String pathToInputFile = scanner.next();
        //TODO output file validation
        System.out.print("Enter the path for output file: ");
        String pathToOutputFile = scanner.next();
        boolean tryAgain;
        int keyEncryption = 0;
        do {
            try {
                System.out.print("Enter encryption key: ");
                keyEncryption = Integer.parseInt(scanner.next());
                tryAgain = false;
            } catch(NumberFormatException e) {
                System.out.println(ANSI_RED + "Invalid number. Try again" + ANSI_RESET);
                tryAgain = true;
            }
        } while(tryAgain);

        operation.encryption(pathToInputFile, pathToOutputFile, keyEncryption);
        System.out.println(ANSI_BLUE + "Encryption done!" + ANSI_RESET);
    }

    private void decryptionMode() {
        System.out.println("Selected decryption mode");
        System.out.print("Enter path to file: ");
        String pathToInputFile = scanner.next();
        //TODO output file validation
        System.out.print("Enter the path for output file: ");
        String pathToOutputFile = scanner.next();
        boolean tryAgain;
        int keyDecryption = 0;
        do {
            try {
                System.out.print("Enter decryption key: ");
                keyDecryption = Integer.parseInt(scanner.next());
                tryAgain = false;
            } catch(NumberFormatException e) {
                System.out.println(ANSI_RED + "Invalid number. Try again" + ANSI_RESET);
                tryAgain = true;
            }
        } while(tryAgain);

        operation.decryption(pathToInputFile, pathToOutputFile, keyDecryption);
        System.out.println(ANSI_BLUE + "Decryption done!" + ANSI_RESET);
    }

    private void decryptionBruteForce() {
        System.out.println("decryptionBruteForce");
    }

    
}
