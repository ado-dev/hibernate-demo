package com.ado.demo.Entities.EmbeddableTypes;


import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * Created by Adnan on 28-Apr-17.
 */

@Embeddable
public class Phone {

    private String manufacturer;
    private String os;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}
