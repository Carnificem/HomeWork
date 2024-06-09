package com.skypro.employee;

import exception.AlreadyAddedException;
import exception.EmployeeNotFoundException;
import exception.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public final int MAX_EMPLOYEES = 12;

    List<Employee> employeesList = new ArrayList<>(List.of(
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


    @GetMapping(path = "/add")
    public Employee add(@RequestParam("name") String name,
                        @RequestParam("surname") String surname) throws AlreadyAddedException, EmployeeStorageIsFullException {
        return EmployeeService.addEmployee(name, surname);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam("name") String name,
                           @RequestParam("surname") String surname) throws EmployeeNotFoundException {

        return EmployeeService.removeEmployee(name, surname);

    }

    @GetMapping(path = "/search")
    private Employee search(@RequestParam("name") String name,
                            @RequestParam("surname") String surname) throws EmployeeNotFoundException {
        return EmployeeService.searchEmployee(name, surname);

    }

    @GetMapping(path = "/all")
    public String getEmployeesList() {
        return EmployeeService.employeesList.toString();
    }


}

