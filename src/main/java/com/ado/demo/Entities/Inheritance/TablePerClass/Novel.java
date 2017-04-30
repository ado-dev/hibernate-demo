package com.ado.demo.Entities.Inheritance.TablePerClass;

import javax.persistence.Entity;


@Entity
public class Novel extends Books {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
