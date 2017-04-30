package com.ado.demo.Entities.AssociationTypes.OneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * DEMONSTRATES OneToOne MAPPING
 */

@Entity
public class Computer {

    @Id
    @GeneratedValue
    private long id;
    private String manufacturer;
    private String type;

    @OneToOne
    private Motherboard motherboard;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard (Motherboard motherboard) {
        this.motherboard = motherboard;
    }
}
