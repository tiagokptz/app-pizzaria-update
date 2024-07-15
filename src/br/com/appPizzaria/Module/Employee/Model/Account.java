package br.com.appPizzaria.Module.Employee.Model;

import br.com.appPizzaria.Module.Employee.Enum.EnumAccountType;

public class Account {
    public String user;
    private String password;
    private EnumAccountType type;
    private boolean isLogged = false;

    public Account(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Account(String user, String password, EnumAccountType type) {
        this.user = user;
        this.password = password;
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EnumAccountType getType() {
        return type;
    }

    public void setType(EnumAccountType type) {
        this.type = type;
    }

    public boolean getIsLogged() {
        return isLogged;
    }

    public void setLogged() {
        this.isLogged = !isLogged;
    }

    @Override
    public String toString() {
        return "<Conta: Usuário=" + this.user + ">";
    }
}
