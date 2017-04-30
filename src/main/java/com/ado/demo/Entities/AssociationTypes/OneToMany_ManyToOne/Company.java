package com.ado.demo.Entities.AssociationTypes.OneToMany_ManyToOne;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DEMONSTRATES BI-DIRECTIONAL OneToMany AND ManyToOne MAPPING
 */

@Entity
public class Company {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    // Using mappedBy creation of new Company_Employee table will be avoided.
    // Cascade specifies which operations will also apply to connected objects.
    // Attribute orphanRemoval specifies whether the data from the Employee table will be
    // removed if the associated Company gets removed.
    // When FetchType is set to eager it will fetch all the data instead of just the first layer.
    @OneToMany (mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Employee> employees = new ArrayList();

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setCompany(this);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        employee.setCompany(null);
    }

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
}
