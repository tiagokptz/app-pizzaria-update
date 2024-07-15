package br.com.appPizzaria.Module.Employee.DAO;

import br.com.appPizzaria.Module.Employee.Interface.IEmployeeDAO;
import br.com.appPizzaria.Module.Employee.Model.Employee;

import java.util.ArrayList;


public class EmployeeDAO implements IEmployeeDAO {

    private ArrayList<Employee> dbEmployees = new ArrayList<>();

    @Override
    public boolean create(Employee e) {
        return this.dbEmployees.add(e);
    }

    @Override
    public Employee retrieve(String user) {
        for(Employee employee : this.dbEmployees) {
            if(employee.getAccount().user.equals(user)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public boolean update(int index, Employee e) {    //"e" e o novo objeto modificado
        Employee oldEmployee = this.dbEmployees.set(index, e);
        if(oldEmployee == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Employee e) {
        return this.dbEmployees.remove(e);
    }

    @Override
    public ArrayList<Employee> listAll() {
        return this.dbEmployees;
    }
}
