package com.ado.demo.Entities.EmbeddableTypes;

import javax.persistence.*;

/**
 * DEMONSTRATES EMBEDDING OBJECTS
 *
 * Embedded objects are used to encapsulate multiple
 * connected data that don't have meaning on their own.
 */

@Entity
public class Person {
    @Id
    @GeneratedValue
    private long id;
    private String name;


    // AttributeOverride is used, when multiple objects of the same class belong
    // to one entity, to override default column names to avoid duplicate column
    // names.
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "manufacturer", column = @Column(name = "Own_Phone_Manufacturer")),
            @AttributeOverride(name = "os", column = @Column(name = "Own_Phone_OS"))
    })
    private Phone ownPhone;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "manufacturer", column = @Column(name = "Work_Phone_Manufacturer")),
            @AttributeOverride(name = "os", column = @Column(name = "Work_Phone_OS"))
    })
    private Phone workPhone;

    public Phone getOwnPhone() {
        return ownPhone;
    }

    public void setOwnPhone(Phone ownPhone) {
        this.ownPhone = ownPhone;
    }

    public Phone getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(Phone workPhone) {
        this.workPhone = workPhone;
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
