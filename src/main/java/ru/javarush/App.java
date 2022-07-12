package ru.javarush;

import ru.javarush.dialogue.Dialogue;
import ru.javarush.dialogue.DialogueConsole;

public class App {
    public static void main(String[] args) {
        Dialogue dialogue = new DialogueConsole();
        dialogue.start();

    }
}
