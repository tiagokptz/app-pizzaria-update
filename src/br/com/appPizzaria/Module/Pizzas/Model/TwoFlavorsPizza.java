package br.com.appPizzaria.Module.Pizzas.Model;

import br.com.appPizzaria.Module.Pizzas.Enum.EnumFlavors;
import br.com.appPizzaria.Module.Pizzas.Enum.EnumSizes;

public class TwoFlavorsPizza extends Pizza{
    public EnumFlavors secondFlavor;
    public TwoFlavorsPizza(EnumFlavors flavor, EnumFlavors secondFlavor, EnumSizes size) {
        super(flavor, size);
        this.secondFlavor = secondFlavor;
    }

    @Override
    public double calculateValuePizza() {
        super.calculateValuePizza();
        this.value += 2 * this.VALUE_PER_FLAVOR;
        return this.value;
    }

    @Override
    public String toString() {
        return "<Pizza: Sabor= " + this.flavor.flavor + " - " + this.secondFlavor.flavor + " | Tamanho= " + this.size.size + " | Valor= " + this.calculateValuePizza() + ">";
    }
}
