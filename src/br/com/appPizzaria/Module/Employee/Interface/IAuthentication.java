package br.com.appPizzaria.Module.Employee.Interface;

import br.com.appPizzaria.Module.Employee.Exception.AuthenticationException;
import br.com.appPizzaria.Module.Employee.Model.Employee;

public interface IAuthentication {
    Employee login(String user, String password) throws AuthenticationException;
    void logout();
}
