package com.ado.demo.Entities.Inheritance.TablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Adnan on 28-Apr-17.
 */

@Entity
@Table(name = "Self_Help")
public class SelfHelp extends Books {

    private String theme;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
