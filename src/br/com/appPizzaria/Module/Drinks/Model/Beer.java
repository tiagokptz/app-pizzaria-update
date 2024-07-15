package br.com.appPizzaria.Module.Drinks.Model;

import br.com.appPizzaria.Module.Drinks.Enum.EnumDrinks;
import br.com.appPizzaria.Module.Drinks.Enum.EnumLiters;

public class Beer extends Drink {
    private boolean alcool;
    public Beer(EnumDrinks name, EnumLiters liters, double value, int quant, boolean alcool) {
        super(name, liters, value, quant);
        this.alcool = alcool;
    }

    @Override
    public String toString() {
        if(!alcool) {
            return super.toString() + " | sem álcool >";
        }
        return super.toString();
    }
}
