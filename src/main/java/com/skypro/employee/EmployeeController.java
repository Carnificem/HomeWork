package com.skypro.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceInterfaceImpl service;

    public EmployeeController(EmployeeServiceInterfaceImpl service) {
        this.service = service;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee (@RequestParam String name ,@RequestParam String surname){
        return service.add(name,surname);
    }
    @GetMapping(path = "/remove")
    public Employee removeEmployee (@RequestParam String name ,@RequestParam String surname) {
        return service.remove(name, surname);
    }

    @GetMapping(path = "/search")
    public Employee searchEmployee (@RequestParam String name ,@RequestParam String surname) {
        return service.search(name, surname);
    }
    @GetMapping
    public List<Employee> viewAll(){
        return service.viewAll();
    }

}


