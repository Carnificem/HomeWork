package com.skypro.employee;

import exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentService implements DepartmentServiceInterface {
    private final EmployeeServiceInterface employeeService;

    public DepartmentService(EmployeeServiceInterface employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int department) {
        return employeeService.viewAll().stream().filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeWithMinSalary(int department) {
        return employeeService.viewAll().stream().filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> findEmployee(int department) {
        return employeeService.viewAll().stream().filter(employee -> employee.getDepartment() == department).toList();
    }


    public Map<Integer, List<Employee>> findEmployeeByDep() {
        return employeeService.viewAll().stream().collect(groupingBy(Employee::getDepartment));
    }


}
