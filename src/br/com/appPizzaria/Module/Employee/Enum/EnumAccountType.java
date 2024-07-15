package br.com.appPizzaria.Module.Employee.Enum;

public enum EnumAccountType {
    MANAGER(0), WAITER(1);

    public int type;

    EnumAccountType(int type) {
        this.type = type;
    }
}
