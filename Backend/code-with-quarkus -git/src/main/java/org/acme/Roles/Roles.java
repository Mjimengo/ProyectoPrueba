package org.acme.Roles;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Roles {

    @Id
    private int id_rol;

    private String name_rol;

    private int salary;

    private String department;

    private int hollidays;



    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getName_rol() {
        return name_rol;
    }

    public void setName_rol(String name_rol) {
        this.name_rol = name_rol;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getHollidays() {
        return hollidays;
    }

    public void setHollidays(int hollidays) {
        this.hollidays = hollidays;
    }


}
