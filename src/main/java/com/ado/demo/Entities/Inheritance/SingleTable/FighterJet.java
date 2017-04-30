package com.ado.demo.Entities.Inheritance.SingleTable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * Created by Adnan on 28-Apr-17.
 */
@Entity
@DiscriminatorValue(value = "Fighter")
public class FighterJet extends Aircraft {

    // used to set the name of the column different from var name
    // had to set different name because name = "Type" is used for Discriminator column
    @Column(name = "Plane_Type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
