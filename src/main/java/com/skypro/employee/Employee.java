package com.skypro.employee;

import java.util.Objects;

public class Employee {
   private String name;
    private String surname;
    private int salary;
    private int department;

    public Employee(String name, String surname, int salary, int department) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
    }

   // public Employee(String name, String surname) {
   //     this.name=name;
   //     this.surname = name;
    //}

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

