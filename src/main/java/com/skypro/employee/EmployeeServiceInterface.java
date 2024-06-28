package com.skypro.employee;

import java.util.List;

public interface EmployeeServiceInterface {

    Employee add(String name, String surname, int salary, int department);

    Employee remove(String name, String surname, int salary, int department);

    Employee search(String name, String surname, int salary, int department);


}
