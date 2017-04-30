package com.ado.demo.Entities.AssociationTypes.OneToMany_ManyToOne;

import javax.persistence.*;

/**
 * Created by Adnan on 29-Apr-17.
 */

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double salary;

    @ManyToOne
    @JoinColumn (name = "Company_id") // specifies the name of the id column
    private Company company;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
