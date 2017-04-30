package com.ado.demo.Entities.Inheritance.SingleTable;

import javax.persistence.*;

import static javax.persistence.DiscriminatorType.STRING;

/**
 * DEMONSTRATES INHERITANCE
 *
 * Demonstrates SINGLE_TABLE strategy - this means that
 * all data will be kept inside of a single table.
 * Good for data which isn't described with many columns.
 * Bad because it can have many null values.
 * Declaring this strategy isn't required as it is the
 * default behavior, here it is annotated only for
 * demonstration purpose.
 */

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
// Discriminator column is used to differentiate between the child classes
// It's "name" value by default is DTYPE, here it is changed to Type.
@DiscriminatorColumn (name = "Type", discriminatorType = STRING, length = 20)
public class Aircraft {
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
