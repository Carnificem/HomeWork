package com.skypro.employee;

import java.util.List;
import java.util.Map;

public interface DepartmentServiceInterface {
    Employee findEmployeeWithMaxSalary(int department);

    Employee findEmployeeWithMinSalary(int department);

    List<Employee> findEmployee(int department);

    Map<Integer, List<Employee>> findEmployeeByDep();
}
