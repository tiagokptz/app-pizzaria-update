package br.com.appPizzaria.Module.Employee.Interface;

import br.com.appPizzaria.Module.Employee.Model.Employee;

import java.util.ArrayList;

public interface IEmployeeDAO {
    boolean create(Employee e);
    Employee retrieve(String user);
    boolean update(int index, Employee e);
    boolean delete(Employee e);
    ArrayList<Employee> listAll();
}
