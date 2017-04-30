package com.ado.demo.Entities.Inheritance.TablePerClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * DEMONSTRATES INHERITANCE
 *
 * Demonstrates TABLE_PER_CLASS strategy - meaning that
 * for every entity there will be a separate table with
 * all of the columns inherited and specific.
 * Id will be inherited from parent if generated.
 */

@Entity
public class Books {

    @Id
    @GeneratedValue
    private long id;
    private String name;

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
