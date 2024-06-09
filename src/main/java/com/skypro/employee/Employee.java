package com.skypro.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {
    String name;
    String surname;

    public Employee(String name, String surname)
    {
        this.name = name;
        this.surname = surname;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       Employee employee = (Employee) o;
       return  Objects.equals(getName(),employee.getName())&&Objects.equals(getSurname(),employee.getSurname());
   }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname());
    }

    @Override
    public String toString() {
        return "<br>Имя сотрудника "+this.name+" "
                +"Фамилия сотрудника " + this.surname;

    }
}
