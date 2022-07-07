package ru.javarush.dialogue;

public enum Menu {
    EXIT(0, "Exit"),
    ENCRYPT(1, "Encryption"),
    DECRYPT_WITH_KEY(2, "Decryption with key");
    //DECRYPT_BRUTE_FORCE(3, "Decryption with brute force"),
    //DECRYPT_STATISTICAL_ANALYSIS(4, "Decryption with statistical analysis");

    private final int order;
    private final String name;

    Menu(int order, String name) {
        this.order = order;
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }

    public static Menu getMenuByNumber(int number) {
        for(Menu menu: values()) {
            if(menu.getOrder() == number) {
                return menu;
            }
        }
        throw new IllegalArgumentException("Wrong menu number");
    }
}
