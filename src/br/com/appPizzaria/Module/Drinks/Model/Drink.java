package br.com.appPizzaria.Module.Drinks.Model;

import br.com.appPizzaria.Module.Drinks.Enum.EnumDrinks;
import br.com.appPizzaria.Module.Drinks.Enum.EnumLiters;

abstract public class Drink {
    public EnumDrinks name;
    public EnumLiters liters;
    private double value;
    private int quantInFreezer;
    private boolean available;

    public Drink(EnumDrinks name, EnumLiters liters, double value, int quant) {
        this.name = name;
        this.liters = liters;
        this.value = value;
        this.quantInFreezer = quant;
        this.available = true;
    }

    public void decreaseQuant() {
        if(this.available) {
            this.quantInFreezer--;
        }

        this.available = false;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        if(this.liters.liters < 1) {
            return "<Bebida: Nome= " + this.name.drink + " | " + (int)(this.liters.liters * 1000)  + " ml | " + "Valor= R$ " + this.value + " | Quantidade no freezer=" + this.quantInFreezer;
        }
        return "<Bebida: Nome= " + this.name.drink + " | " + (int)this.liters.liters  + " L | " + "Valor= R$ " + this.value + " | Quantidade no freezer=" + this.quantInFreezer;
    }
}
