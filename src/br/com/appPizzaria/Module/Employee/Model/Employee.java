package br.com.appPizzaria.Module.Employee.Model;

import br.com.appPizzaria.Module.Employee.Enum.EnumAccountType;

abstract public class Employee {
    public String name;
    //public int age; //fazer método para calcular a idade usando o dateOfBirth
    public Date dateOfBirth;
    private Account account;

    public Employee(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.account = null;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public abstract void createAccount(String user, String password);

    @Override
    public String toString() {
        return "Nome= " + this.name + ", Data de Nascimento= " + this.dateOfBirth + ", Conta= " + this.account + ">";
    }
}
