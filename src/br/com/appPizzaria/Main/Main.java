package br.com.appPizzaria.Main;

import br.com.appPizzaria.Module.Drinks.Enum.EnumDrinks;
import br.com.appPizzaria.Module.Drinks.Enum.EnumLiters;
import br.com.appPizzaria.Module.Drinks.Model.Beer;
import br.com.appPizzaria.Module.Drinks.Model.Drink;
import br.com.appPizzaria.Module.Drinks.Model.Soda;
import br.com.appPizzaria.Module.Drinks.Model.Water;
import br.com.appPizzaria.Module.Employee.Controller.EmployeeController;
import br.com.appPizzaria.Module.Employee.Enum.EnumMonth;
import br.com.appPizzaria.Module.Employee.Model.Date;
import br.com.appPizzaria.Module.Employee.Model.Employee;
import br.com.appPizzaria.Module.Employee.Model.Manager;
import br.com.appPizzaria.Module.Employee.Model.Waiter;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean start = true;
    public static Employee employeeLogged;
    public static Manager managerLogged;
    public static Waiter waiterLogged;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Manager manager = new Manager("Tiago", new Date(6,EnumMonth.NOVEMBER, 2005));
        manager.createAccount("tiagokptz", "12345");

        Waiter waiter1 = new Waiter("Tiago", new Date(6, EnumMonth.NOVEMBER, 2005));
        waiter1.createAccount("tiago", "12345");

        EmployeeController controller = new EmployeeController();

        controller.create(manager);
        controller.create(waiter1);

        ArrayList<Drink> freezer = new ArrayList<>();

        Soda coca = new Soda(EnumDrinks.COCA_COLA, EnumLiters.UM_LITRO, 8, 50, false);
        Water water = new Water(EnumDrinks.AGUA, EnumLiters.UM_LITRO, 6, 50, false);
        Beer heineken = new Beer(EnumDrinks.HEINEKEN, EnumLiters.LONG_NECK, 14, 40, false);

        freezer.add(coca);
        freezer.add(water);
        freezer.add(heineken);

        while(start) {
            System.out.println(
                    "_______________________" + "\n" +
                    "Pizzaria               " + "\n" +
                    "[1] Login              " + "\n" +
                    "[0] Sair               " + "\n" +
                    "_______________________"
            );

            int option = scanner.nextInt();
            scanner.nextLine();

            switch(option) {
                case 1:
                    System.out.print("Usuário: ");
                    String user = scanner.nextLine();

                    System.out.print("Senha: ");
                    String password = scanner.nextLine();

                    employeeLogged = controller.login(user, password);

                    if(employeeLogged == null) {
                        continue;
                    }

                    switch(employeeLogged.getAccount().getType().type) {
                        case 0:
                            managerLogged = (Manager)employeeLogged;

                            while(employeeLogged.getAccount().getIsLogged()) {
                                System.out.println(
                                        "________________________" + "\n" +
                                        "[1] Contratar garçom    " + "\n" +
                                        "[2] Demitir garçom      " + "\n" +
                                        "[3] Planilha de garçons " + "\n" +
                                        "[0] Sair                " + "\n" +
                                        "________________________"
                                );

                                int optionManager = scanner.nextInt();
                                scanner.nextLine();

                                switch(optionManager) {
                                    case 1:
                                        controller.create(managerLogged.toHire());
                                        break;
                                    case 2:
                                        controller.delete(controller.retrieve(managerLogged.dismiss()));
                                        break;
                                    case 3:
                                        controller.listAll();
                                        break;
                                    case 0:
                                        controller.logout();
                                        break;
                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                            }
                            break;

                        case 1:
                            waiterLogged = (Waiter)employeeLogged;

                            while(employeeLogged.getAccount().getIsLogged()) {
                                System.out.println(
                                        "________________________" + "\n" +
                                        "[1] Anotar pedido       " + "\n" +
                                        "[0] Sair                " + "\n" +
                                        "________________________"
                                );

                                int optionWaiter = scanner.nextInt();
                                scanner.nextLine();

                                switch(optionWaiter) {
                                    case 1:
                                        waiterLogged.takeOrder(freezer);
                                        break;
                                    case 0:
                                        controller.logout();
                                        break;
                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                            }
                            break;
                    }
                    break;

                case 0:
                    start = false;
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
