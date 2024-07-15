package br.com.appPizzaria.Module.Pizzas.Model;

import br.com.appPizzaria.Module.Pizzas.Enum.EnumFlavors;
import br.com.appPizzaria.Module.Pizzas.Enum.EnumSizes;

public class OneFlavorPizza extends Pizza{
    public OneFlavorPizza(EnumFlavors flavor, EnumSizes size) {
        super(flavor, size);
    }

    @Override
    public double calculateValuePizza() {
        super.calculateValuePizza();
        this.value += this.VALUE_PER_FLAVOR;
        return this.value;
    }

    @Override
    public String toString() {
        return super.toString() + " | Valor= " + this.calculateValuePizza() + ">";
    }
}
