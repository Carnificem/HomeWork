package com.skypro.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/department")
@RestController
public class DepartamentController {
    private final DepartmentService serviceDep;

    public DepartamentController(DepartmentService serviceDep) {
        this.serviceDep = serviceDep;
    }

    @GetMapping("max-salary")
    public Employee findEmployeeWithMaxSalary(@RequestParam int department) {
        return serviceDep.findEmployeeWithMaxSalary(department);
    }

    @GetMapping("min-salary")
    public Employee findEmployeeWithMinSalary(@RequestParam int department) {
        return serviceDep.findEmployeeWithMinSalary(department);
    }

    @GetMapping(value = "/all", params = {"department"})
    List<Employee> findEmployee(@RequestParam int department) {
        return serviceDep.findEmployee(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findEmployeeByDep() {
        return serviceDep.findEmployeeByDep();
    }
}
