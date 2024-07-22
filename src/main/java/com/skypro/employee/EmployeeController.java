package com.skypro.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceInterface service;

    public EmployeeController(EmployeeServiceInterface service) {
        this.service = service;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String name, @RequestParam String surname, @RequestParam int salary, @RequestParam int department) throws InvalidInputException {
        return service.add(name,surname,salary, department);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam String name, @RequestParam String surname) throws InvalidInputException {
        return service.remove(name,surname);
    }

    @GetMapping(path = "/search")
    public Employee searchEmployee(@RequestParam String name, @RequestParam String surname) throws InvalidInputException {
        return service.search(name, surname);
    }

    @GetMapping
    public Collection<Employee> viewAll() {
        return service.viewAll();
    }

}


