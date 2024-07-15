package br.com.appPizzaria.Module.Employee.Model;

import br.com.appPizzaria.Module.Employee.Enum.EnumAccountType;
import br.com.appPizzaria.Module.Employee.Enum.EnumMonth;
import br.com.appPizzaria.Module.Employee.Interface.IHR;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Manager extends Employee implements IHR{

    private Scanner scanner;
    public Manager(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
        this.scanner = new Scanner(System.in);
    }

    private Waiter waiterDetails() {
        String name;
        LocalDate birthDate;

        while(true) {
            System.out.print("Nome: ");
            name = scanner.nextLine().trim();

            System.out.print("Data de nascimento (dia/mês/ano): ");
            String dateInput = scanner.nextLine().trim();

            if(name.isEmpty() || dateInput.isEmpty()) {
                System.out.println("\u001B[31mTodos os campos devem ser preenchidos\u001B[0m");
                continue;
            }

            try {
                birthDate = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("d/M/yyyy"));

                if(LocalDate.now().getYear() - birthDate.getYear() >= 18) { //melhorar a validação
                    break;
                }

                System.out.printf("\u001B[31m%s não atingiu a maioridade.\u001B[0m%n", name);

            } catch(DateTimeParseException error) {
                System.out.println("\u001B[31mInforme uma data válida.\u001B[0m");

            }
        }

        return new Waiter(name,
                new Date(
                        birthDate.getDayOfMonth(),
                        EnumMonth.values()[birthDate.getMonthValue() - 1],
                        birthDate.getYear())
        );
    }

    @Override
    public Waiter toHire() {
        Waiter newWaiter = this.waiterDetails();

        String user, password;

        while(true) {
            System.out.print("Usuário: ");
            user = scanner.nextLine();

            if(user.isEmpty()) {
                System.out.println("\u001B[31mO campo deve ser preenchido\u001B[0m");
                continue;
            }

            System.out.print("Senha: ");
            password = scanner.nextLine();

            if(password.length() < 4) {
                System.out.println("\u001B[31mSenha fraca.\u001B[0m");
                continue;
            }

            break;
        }

        newWaiter.createAccount(user, password);

        return newWaiter;
    }

    @Override
    public String dismiss() {
        String userWaiter;

        while(true) {
            System.out.print("Usuário do garçom: ");
            userWaiter = scanner.nextLine();

            if(userWaiter.isEmpty()) {
                System.out.println("\u001B[31mO campo deve ser preenchido\u001B[0m");
                continue;
            }

            break;
        }

        return userWaiter;
    }

    @Override
    public void createAccount(String user, String password) {
        this.setAccount(new Account(user, password, EnumAccountType.MANAGER));
    }

    @Override
    public String toString() {
        return "<Gerente: " + super.toString();
    }
}
