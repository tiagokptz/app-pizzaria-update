package br.com.appPizzaria.Module.Pizzas.Model;

import br.com.appPizzaria.Module.Drinks.Model.Drink;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private Scanner scanner;
    private int tableNumber;
    private ArrayList<Pizza> pizzasList;
    private ArrayList<Drink> drinksList;
    private double value = 0;

    public Order(int tableNumber) {
        this.scanner = new Scanner(System.in);
        this.pizzasList = new ArrayList<>();
        this.drinksList = new ArrayList<>();

        this.tableNumber = tableNumber;
    }

    public void addPizza(Pizza pizza) {
        if(pizza != null) {
            pizzasList.add(pizza);
        }
    }

    public void addDrink(Drink drink) {
        if(drink != null) {
            drinksList.add(drink);
            drink.decreaseQuant();
        }
    }

    public double calculateValueOrder() {
        double total = 0;

        for(Pizza pizza : this.pizzasList) {
            total += pizza.calculateValuePizza();
        }

        for(Drink drink : this.drinksList){
            total += drink.getValue();
        }

        return this.value = total;
    }

    public void order() {
        System.out.println("________________________");
        if(!this.pizzasList.isEmpty()) {
            System.out.println("+-+-+Pizzas+-+-+");
            for(Pizza pizza : pizzasList) {
                System.out.println(pizza + "\n_ _ _ _ _ _ _ _ _ _ _ _ _");
            }
        }

        if(!this.pizzasList.isEmpty()) {
            System.out.println("+-+-+Bebidas:+-+-+");
            for(Drink drink : drinksList) {
                System.out.println(drink + "\n_ _ _ _ _ _ _ _ _ _ _ _ _");
            }
        }

        System.out.println("Valor total: " + this.calculateValueOrder());
        System.out.println("________________________");
    }


    @Override
    public String toString() {
        return "<Pedido: Número da mesa=" + this.tableNumber + " | Pizzas=" + this.pizzasList + " | Bebidas=" + this.drinksList + " | Valor Total= " + this.value + ">";
    }
}
