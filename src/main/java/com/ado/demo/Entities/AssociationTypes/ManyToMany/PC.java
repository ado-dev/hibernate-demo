package com.ado.demo.Entities.AssociationTypes.ManyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adnan on 29-Apr-17.
 */

@Entity
public class PC {
    @Id
    @GeneratedValue
    private long id;

    private String manufacturer;

    @ManyToMany (cascade = CascadeType.ALL)
    private List<Player> player = new ArrayList<Player>();

    public List<Player> getPlayer() {
        return player;
    }

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
}
