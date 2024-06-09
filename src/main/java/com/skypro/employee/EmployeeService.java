package com.skypro.employee;

import exception.AlreadyAddedException;
import exception.EmployeeNotFoundException;
import exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    public static final int MAX_EMPLOYEES = 12;

    static List<Employee> employeesList = new ArrayList<>(List.of(
            new Employee("Пушкин", "Александр"),
            new Employee("Лермонтов ", "Михаил"),
            new Employee("Бродский", "Иосиф"),
            new Employee("Маяковский", "Владимир"),
            new Employee("Тургенев", "Иван"),
            new Employee("Булгаков", "Михаил"),
            new Employee("Бехтерев", " Владимир"),
            new Employee("Климов", "Григорий"),
            new Employee("Есенин", "Сергей"),
            new Employee("Михаил", "Салтыков-Щедрин")));

    public static Employee addEmployee(String name, String surname) throws EmployeeStorageIsFullException, AlreadyAddedException {
        Employee employee = new Employee(name, surname);
        if (employeesList.size() == MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Нет места для добавления сотрудника");
        }
        if (employeesList.contains(employee))
            throw new AlreadyAddedException("Сотрудник с таким именем есть в базе");
        employeesList.add(employee);
        return employee;

    }

    public static Employee removeEmployee(String name, String surname) throws EmployeeNotFoundException {
        Employee employee = new Employee(name, surname);
        if (!employeesList.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник отсутствует в базе");
        }
        employeesList.remove(employee);
        return employee;
    }

    public static Employee searchEmployee(String name, String surname) throws EmployeeNotFoundException {

        Employee searchEmployee = new Employee(name, surname);
        if (!employeesList.contains(searchEmployee)) {
            throw new EmployeeNotFoundException("Сотрудник отсутствует в базе");
        }
        for (Employee employee : employeesList) {
            if (employee.equals(searchEmployee)) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> allEmployees() {
        return employeesList;
    }
}


