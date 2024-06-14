package com.skypro.employee;

import exception.AlreadyAddedException;
import exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class EmployeeServiceInterfaceImpl implements EmployeeServiceInterface {
    private final List<Employee> employeeList;


    public EmployeeServiceInterfaceImpl() {
        this.employeeList = new ArrayList<>();
    }

    @Override
    public Employee add(String name, String surname) {
        Employee employee = new Employee(name,surname);
        if (employeeList.contains(employee)){
            throw new AlreadyAddedException();
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String name, String surname) {
        Employee employee = new Employee(name,surname);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee search(String name, String surname){
    Employee employee = new Employee(name,surname);

    if (employeeList.contains(employee)){
        return employee;
    }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> viewAll(){
        return employeeList;
    }


    }

