package br.com.appPizzaria.Module.Pizzas.Enum;

public enum EnumFlavors {
    CALABRESA("Calabresa"), FRANGO_CATUPIRY("Frango com catupiry"), QUATRO_QUEIJOS("Quatro queijos"),
    CARNE_SOL("Carne de sol"), CROCK("Crock"), PORTUGUESA("Portuguesa"), MARGUERITA("Marguerita"),
    DOIS_AMORES("Dois amores"), CHOCOLATE_MORANGO("Chocolate com morango");

    public final String flavor;

    EnumFlavors(String flavor) {
        this.flavor = flavor;
    }
}
