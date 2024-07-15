package br.com.appPizzaria.Module.Employee.Controller;

import br.com.appPizzaria.Module.Employee.DAO.EmployeeDAO;
import br.com.appPizzaria.Module.Employee.Error.*;
import br.com.appPizzaria.Module.Employee.Exception.*;
import br.com.appPizzaria.Module.Employee.Interface.IAuthentication;
import br.com.appPizzaria.Module.Employee.Model.Employee;


public class EmployeeController implements IAuthentication {
    private EmployeeDAO dao = new EmployeeDAO();

    private void checkAccount(Employee e) throws CreateException {
        if(e.getAccount() == null) {
            throw new CreateException(CreateError.NO_ACCOUNT_ERROR);
        }
    }

    private void checkUser(Employee e) throws CreateException {
        for(Employee employee : this.dao.listAll()) {
            if(employee.getAccount().user.equals(e.getAccount().user)) {
                throw new CreateException(CreateError.USER_EXISTS_ERROR);
            }
        }
    }

    public boolean create(Employee e) {
        try {
            this.checkAccount(e);
            this.checkUser(e);

            return this.dao.create(e);

        } catch(CreateException error) {
            System.out.println("\u001B[31m" + error.getMessage() + "\u001B[0m");
            return false;
        }
    }

    public Employee retrieve(String user) {
        Employee employee = this.dao.retrieve(user);

        try {
            if(employee == null) {
                throw new RetrieveException(RetrieveError.USER_NOT_FOUND_ERROR);
            }

        } catch(RetrieveException error) {
            System.out.println("\u001B[31m" + error.getMessage() + "\u001B[0m");
        }
        return employee;
    }

    public void checkUpdated(int index, Employee e) throws UpdateException{
        if(!this.dao.update(index, e)){
            throw new UpdateException(UpdateError.UNABLE_UPDATE);
        }
    }

    public boolean update(int index, Employee e) {
        try {
            this.checkAccount(e);
            this.checkUpdated(index, e);

            return true;

        } catch(UpdateException | CreateException error) {
            System.out.println("\u001B[31m" + error.getMessage() + "\u001B[0m");
            return false;
        }
    }

    public boolean delete(Employee e) {
        try {
            if(!this.dao.delete(e)) {
                throw new DeleteException(DeleteError.DELETE_ERROR);
            }

            return true;

        } catch(DeleteException error) {
            System.out.println("\u001B[31m" + error.getMessage() + "\u001B[0m");
            return false;
        }
    }

    public void listAll() {
        for(Employee employee : this.dao.listAll()) {
            System.out.println(employee);
        }
    }

    public Employee checkUserPassword(String user, String password) {
        for(Employee employee : this.dao.listAll()) {
            if(employee.getAccount().user.equals(user) && employee.getAccount().getPassword().equals(password)) {
                return employee;
            }
        }
        return null;
    }


    @Override
    public Employee login(String user, String password) {
        Employee returnedEmployee = this.checkUserPassword(user, password);
        try {
            if(returnedEmployee == null) {
                throw new AuthenticationException(AuthenticationError.CREDENTIALS_INVALID);
            }

            returnedEmployee.getAccount().setLogged();
            return returnedEmployee;

        } catch(AuthenticationException error) {
            System.out.println("\u001B[31m" + error.getMessage() + "\u001B[0m");
            return null;
        }
    }
    @Override
    public void logout() {
        for(Employee employee : this.dao.listAll()) {
            if(employee.getAccount().getIsLogged()){
                employee.getAccount().setLogged();
            }
        }
    }
}
