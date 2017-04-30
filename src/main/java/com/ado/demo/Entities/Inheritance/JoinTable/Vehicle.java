package com.ado.demo.Entities.Inheritance.JoinTable;

import javax.persistence.*;

/**
 * DEMONSTRATES INHERITANCE
 *
 * Demonstrates JOINED strategy - this means that all common
 * properties will be in the Vehicle table, and all child
 * specific properties will be in the child table
 */

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public class Vehicle {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
