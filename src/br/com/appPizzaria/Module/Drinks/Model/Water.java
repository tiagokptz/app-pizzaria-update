package br.com.appPizzaria.Module.Drinks.Model;

import br.com.appPizzaria.Module.Drinks.Enum.EnumDrinks;
import br.com.appPizzaria.Module.Drinks.Enum.EnumLiters;

public class Water extends Drink {
    private boolean sparklingWater;
    public Water(EnumDrinks name, EnumLiters liters, double value, int quant, boolean sparklingWater) {
        super(name, liters, value, quant);
        this.sparklingWater = sparklingWater;
    }

    @Override
    public String toString() {
        if(sparklingWater) {
            return super.toString() + " | com gás>";
        }
        return super.toString();
    }
}
