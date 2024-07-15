package br.com.appPizzaria.Module.Drinks.Model;

import br.com.appPizzaria.Module.Drinks.Enum.EnumDrinks;
import br.com.appPizzaria.Module.Drinks.Enum.EnumLiters;

public class Soda extends Drink {
    private boolean noSugar;
    public Soda(EnumDrinks name, EnumLiters liters, double value, int quant, boolean noSugar) {
        super(name, liters, value, quant);
        this.noSugar = noSugar;
    }

    @Override
    public String toString() {
        if(noSugar) {
            return super.toString() + " | zero çúcar >";
        }
        return super.toString();
    }
}
