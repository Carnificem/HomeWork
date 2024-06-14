package com.skypro.employee;

import java.util.List;

public interface EmployeeServiceInterface {

    Employee add(String name, String surname);
    Employee remove(String name,String surname);
    Employee search(String name,String surname);
}
