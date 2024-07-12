package com.skypro.employee;

import exception.AlreadyAddedException;
import exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceInterfaceImpl implements EmployeeServiceInterface {
    private final Map<String, Employee> employees;


    public EmployeeServiceInterfaceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String name, String surname, int salary, int department) {
        if (employees.containsKey(name)) {
            throw new AlreadyAddedException();
        } else {
            employees.put(name, new Employee(name, surname, salary, department));
        }

        return employees.get(name);
    }

    @Override
    public Employee remove(String name, String surname) {
        if (employees.containsKey(name)) {
            employees.remove(name);
        } else {
            throw new EmployeeNotFoundException();
        }
        return employees.get(name);
    }


    @Override
    public Employee search(String name, String surname) {
        if (!employees.containsKey(name)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(name);
    }


    public Collection<Employee> viewAll() {
        return Collections.unmodifiableCollection(employees.values());
    }


}

