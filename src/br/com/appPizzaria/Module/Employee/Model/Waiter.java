package br.com.appPizzaria.Module.Employee.Model;

import br.com.appPizzaria.Module.Drinks.Model.Drink;
import br.com.appPizzaria.Module.Employee.Enum.EnumAccountType;
import br.com.appPizzaria.Module.Pizzas.Enum.EnumFlavors;
import br.com.appPizzaria.Module.Pizzas.Enum.EnumSizes;
import br.com.appPizzaria.Module.Pizzas.Model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Waiter extends Employee{

    private Scanner scanner;
    private Order order;

    public Waiter(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
        this.scanner = new Scanner(System.in);
    }

    private int validateInput(String msg) {
        int number;

        do {
            System.out.print(msg);
            try {
                number = scanner.nextInt();
                scanner.nextLine();
                break;

            } catch(InputMismatchException error) {
                System.out.println("\u001B[31mA entrada deve ser um número.Tente novamente.\u001B[0m");
                scanner.nextLine();
            }
        } while(true);

        return number;
    }

    private void showFlavors() {
        System.out.println(
                "_ _ _ _ _ _ _ _ _ _ _ _ _" + "\n" +
                "Sabores:                 "
        );
        for(int i = 0; i < EnumFlavors.values().length; i++){
            System.out.printf("[%d] %s\n", i, EnumFlavors.values()[i].flavor);
        }
    }

    private void showSizes() {
        System.out.println(
                "_ _ _ _ _ _ _ _ _ _ _ _ _" + "\n" +
                "Tamanhos:                "
        );
        for(int i = 0; i < EnumSizes.values().length; i++) {
            System.out.printf("[%d] %s\n", i, EnumSizes.values()[i].size);
        }
    }

    private void showFreezer(ArrayList<Drink> freezer) {
        System.out.println(
                "_ _ _ _ _ _ _ _ _ _ _ _ _" + "\n" +
                "Bebidas:                "
        );
        for(int i = 0; i < freezer.size(); i++) {
            System.out.printf("[%d] %s\n", i + 1, freezer.get(i));
        }
    }

    private int validateFlavors(String msg) {
        int flavorNum;
        boolean validated = false;

        do {
            flavorNum = this.validateInput(msg);
            if(flavorNum >= 0 && flavorNum < EnumFlavors.values().length) {
                validated = true;
            } else {
                System.out.println("\u001B[31mEsse sabor não existe. Tente novamente.\u001B[0m");
            }
        } while(!validated);

        return flavorNum;
    }

    private int validateSize() {
        int sizeNum;
        boolean validated = false;

         do {
             sizeNum = this.validateInput(
                     "_ _ _ _ _ _ _ _ _ _ _ _ _" + "\n" +
                          "Tamanho: "
             );
             if(sizeNum >= 0 && sizeNum < EnumSizes.values().length) {
                 validated = true;
             } else {
                 System.out.println("\u001B[31mEsse tamanho não existe. Tente novamente.\u001B[0m");
             }
         } while(!validated);

         return sizeNum;
    }

    private OneFlavorPizza makeOneFlavorPizza() {
        int firstFlavorNum = this.validateFlavors(
                "_ _ _ _ _ _ _ _ _ _ _ _ _" + "\n" +
                     "Número do sabor: "
        );
        int size = this.validateSize();

        return new OneFlavorPizza(EnumFlavors.values()[firstFlavorNum], EnumSizes.values()[size]);
    }

    private TwoFlavorsPizza makeTwoFlavorsPizza() {
        int firstFlavorNum = this.validateFlavors(
                "_ _ _ _ _ _ _ _ _ _ _ _ _" + "\n" +
                     "Número do primeiro sabor: "
        );
        int secondFlavorNum = this.validateFlavors(
                "_ _ _ _ _ _ _ _ _ _ _ _ _" + "\n" +
                     "Número do segundo sabor: "
        );
        int size = this.validateSize();

        if(firstFlavorNum == secondFlavorNum) {
            System.out.println("\u001B[31mA pizza deve conter sabores diferentes.\u001B[0m");
            return null;
        }

        if(size == 0) {
            System.out.println("\u001B[31mUma pizza pequena não pode conter dois/três sabores.\u001B[0m");
            return null;
        }

        return new TwoFlavorsPizza(
                EnumFlavors.values()[firstFlavorNum],
                EnumFlavors.values()[secondFlavorNum],
                EnumSizes.values()[size]
        );
    }

    private ThreeFlavorsPizza makeThreeFlavoresPizza() {
        int firstFlavorNum = this.validateFlavors(
                "_ _ _ _ _ _ _ _ _ _ _ _ _" + "\n" +
                     "Número do primeiro sabor: "
        );
        int secondFlavorNum = this.validateFlavors(
                "_ _ _ _ _ _ _ _ _ _ _ _ _" + "\n" +
                     "Número do segundo sabor: "
        );
        int thirdFlavorNum = this.validateFlavors(
                "_ _ _ _ _ _ _ _ _ _ _ _ _" + "\n" +
                     "Número do terceiro sabor: "
        );
        int size = this.validateSize();

        if(firstFlavorNum == secondFlavorNum || firstFlavorNum == thirdFlavorNum || secondFlavorNum == thirdFlavorNum) {
            System.out.println("\u001B[31mA pizza deve conter sabores diferentes.\u001B[0m");
            return null;
        }

        if(size == 0) {
            System.out.println("\u001B[31mUma pizza pequena não pode conter dois/três sabores.\u001B[0m");
            return null;
        }

        return new ThreeFlavorsPizza(
                EnumFlavors.values()[firstFlavorNum],
                EnumFlavors.values()[secondFlavorNum],
                EnumFlavors.values()[thirdFlavorNum],
                EnumSizes.values()[size]
        );
    }

    private void makeOrderPizza() {
        int i = 1;
        while(true) {
            System.out.printf("[%dª] pizza:            " + "\n", i);

            this.showFlavors();
            this.showSizes();

            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
            int quantFlavors = this.validateInput("Quantidade de sabores: ");

            switch(quantFlavors){
                case 1:
                    this.order.addPizza(this.makeOneFlavorPizza());
                    break;
                case 2:
                    this.order.addPizza(this.makeTwoFlavorsPizza());
                    break;
                case 3:
                    this.order.addPizza(this.makeThreeFlavoresPizza());
                    break;
                default:
                    System.out.println("Uma pizza só pode conter 3 sabores.");
                    break;
            }

            System.out.print(
                    "_ _ _ _ _ _ _ _ _ _ _ _ _" + "\n" +
                    "Deseja continuar? (1-Sim)(0-Não)"
            );
            boolean continueLoop = scanner.nextLine().trim().equals("1");

            if(!continueLoop) {
                break;
            }

            i++;
        }
        //System.out.println(order);
    }

    private void makeOrderDrink(ArrayList<Drink> freezer) {
        while(true) {

            this.showFreezer(freezer);

            int i = 1;
            while(true) {
                System.out.printf(
                        "________________________" + "\n" +
                        "[%dª] bebida:            " + "\n", i
                );

                int option = this.validateInput("Número da bebida: ");
                try {
                    this.order.addDrink(freezer.get(option - 1));
                    i++;
                    break;
                } catch(IndexOutOfBoundsException error) {
                    System.out.printf("\u001B[31mO freezer não contém a bebida([%d]).Tente novamente!\n\u001B[0m",option - 1);
                }
            }

            System.out.print(
                    "_ _ _ _ _ _ _ _ _ _ _ _ _" + "\n" +
                    "Deseja continuar? (1-Sim)(0-Não)"
            );
            boolean continueLoop = scanner.nextLine().trim().equals("1");

            if(!continueLoop) {
                break;
            }
        }
        this.order.order();
    }

    public void takeOrder(ArrayList<Drink> freezer) {
        boolean start = true;

        System.out.println("________________________");

        this.order = new Order(validateInput("Número da mesa: "));

        while(start) {
            System.out.println(
                    "_________OPÇÕES_________" + "\n" +
                    "[1]Pizza com bebida     " + "\n" +
                    "[2]Pizza                " + "\n" +
                    "[3]Bebida               " + "\n" +
                    "[0]Sair                 " + "\n" +
                    "________________________"
            );

            int option = this.validateInput("Escolha uma opção: ");

            switch(option) {
                case 1:
                    this.makeOrderPizza();
                    this.makeOrderDrink(freezer);
                    start = false;
                    break;
                case 2:
                    this.makeOrderPizza();
                    start = false;
                    break;
                case 3:
                    this.makeOrderDrink(freezer);
                    start = false;
                    break;
                case 0:
                    start = false;
                    break;
                default:
                    System.out.println("\u001B[31mOpção inválida.\u001B[0m");
                    break;
            }
        }
        this.order.calculateValueOrder();
    }

    @Override
    public void createAccount(String user, String password) {
        this.setAccount(new Account(user, password, EnumAccountType.WAITER));
    }

    @Override
    public String toString() {
        return "<Garçom: " + super.toString();
    }
}
