package br.com.appPizzaria.Module.Pizzas.Model;

import br.com.appPizzaria.Module.Pizzas.Enum.EnumFlavors;
import br.com.appPizzaria.Module.Pizzas.Enum.EnumSizes;

abstract public class Pizza {
    public final double VALUE_PER_FLAVOR = 8;
    public EnumFlavors flavor;
    public EnumSizes size;
    public double value = 0;

    public Pizza(EnumFlavors flavor, EnumSizes size) {
        this.flavor = flavor;
        this.size = size;
    }

    public double calculateValuePizza() {
        switch(this.size.size) {
            case "P":
                this.value = 23;
                break;
            case "M":
                this.value = 28;
                break;
            case "G":
                this.value = 33;
                break;
            default:
                this.value = 0;
                break;
        }
        return value;
    }

    @Override
    public String toString() {
        return "<Pizza: Sabor= " + this.flavor.flavor + " | Tamanho= " + this.size.size;
    }
}