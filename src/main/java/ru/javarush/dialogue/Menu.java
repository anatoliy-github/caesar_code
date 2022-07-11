package ru.javarush.dialogue;

public enum Menu {
    EXIT("Exit"),
    ENCRYPT("Encryption"),
    DECRYPT_WITH_KEY("Decryption with key"),
    DECRYPT_BRUTE_FORCE("Decryption with brute force");
    //DECRYPT_STATISTICAL_ANALYSIS("Decryption with statistical analysis");

    private final String name;

    Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Menu getMenuByNumber(int number) {
        for(Menu menu: values()) {
            if(menu.ordinal() == number) {
                return menu;
            }
        }
        throw new IllegalArgumentException("Wrong menu number");
    }
}
