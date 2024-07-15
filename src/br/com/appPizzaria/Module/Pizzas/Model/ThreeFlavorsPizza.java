package br.com.appPizzaria.Module.Pizzas.Model;

import br.com.appPizzaria.Module.Pizzas.Enum.EnumFlavors;
import br.com.appPizzaria.Module.Pizzas.Enum.EnumSizes;

public class ThreeFlavorsPizza extends Pizza {
    public EnumFlavors secondFlavor;
    public EnumFlavors thirdFlavor;
    public ThreeFlavorsPizza(EnumFlavors flavor, EnumFlavors secondFlavor, EnumFlavors thirdFlavor, EnumSizes size) {
        super(flavor, size);
        this.secondFlavor = secondFlavor;
        this.thirdFlavor = thirdFlavor;
    }

    @Override
    public double calculateValuePizza() {
        super.calculateValuePizza();
        this.value += 3 * this.VALUE_PER_FLAVOR;
        return this.value;
    }

    @Override
    public String toString() {
        return "<Pizza: Sabor= " + this.flavor.flavor + " - " + this.secondFlavor.flavor + " - " + this.thirdFlavor.flavor +
                " | Tamanho= " + this.size.size + " | Valor= " + this.calculateValuePizza() + ">";
    }
}
