package com.skypro.employee;

import java.util.Collection;

public interface EmployeeServiceInterface {

    Employee add(String name, String surname, int salary, int department);

    Employee remove(String name, String surname);

    Employee search(String name, String surname);


    Collection<Employee> viewAll();
}
