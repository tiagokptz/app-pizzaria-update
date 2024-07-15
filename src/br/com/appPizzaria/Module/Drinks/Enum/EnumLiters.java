package br.com.appPizzaria.Module.Drinks.Enum;

public enum EnumLiters {
    DOIS_LITROS(2), UM_LITRO(1), LATA(0.35), LONG_NECK(0.6);

    public final double liters;

    EnumLiters(double liters) {
        this.liters = liters;
    }

}
