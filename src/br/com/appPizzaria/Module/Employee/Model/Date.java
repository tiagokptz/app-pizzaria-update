package br.com.appPizzaria.Module.Employee.Model;

import br.com.appPizzaria.Module.Employee.Enum.EnumMonth;

public class Date {
    public int day;
    public EnumMonth month;
    public int year;

    public Date(int day, EnumMonth month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return "<Data: " + this.day + "/" + this.month.month + "/" + this.year + ">";
    }
}
