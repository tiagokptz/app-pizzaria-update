package br.com.appPizzaria.Module.Pizzas.Enum;

public enum EnumSizes {
    SMALL("P"), AVERAGE("M"), LARGE("G");

    public String size;

    EnumSizes(String size) {
        this.size = size;
    }
}
