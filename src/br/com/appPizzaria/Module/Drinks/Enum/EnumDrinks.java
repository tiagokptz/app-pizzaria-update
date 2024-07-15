package br.com.appPizzaria.Module.Drinks.Enum;

public enum EnumDrinks {
    COCA_COLA("Coca-cola"), GUARANA("Guaraná"), PEPSI("Pepsi"), FANTA("Fanta"),
    BUDWEISER("Budweiser"), AMSTEL("Amstel"), HEINEKEN("Heineken"), BRAHMA("Brahma"),
    AGUA("Água");

    public final String drink;

    EnumDrinks(String drink) {
        this.drink = drink;
    }
}
