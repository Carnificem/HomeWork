package com.skypro.employee;

import exception.AlreadyAddedException;
import exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceInterfaceImpl implements EmployeeServiceInterface {
    private final Map<String,Employee> employees;


    public EmployeeServiceInterfaceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String name, String surname) {
        Employee employee = new Employee(name,surname);
        if (employees.containsKey(employee.getAllName())){
            throw new AlreadyAddedException();
        }
        employees.put(employee.getAllName(),employee);
        return employee;
    }

    @Override
    public Employee remove(String name, String surname) {
        Employee employee = new Employee(name,surname);
        if (employees.containsKey(employee.getAllName())) {
            employees.remove(employee.getAllName());
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee search(String name, String surname){
    Employee employee = new Employee(name,surname);

    if (employees.containsKey(employee.getAllName())){
        return employees.get(employee.getAllName());
    }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> viewAll(){

        return Collections.unmodifiableCollection(employees.values());
    }


    }

