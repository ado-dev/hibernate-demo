package com.ado.demo.Entities.Collections;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * DEMONSTRATES ADDING COLLECTIONS TO ENTITIES
 * Collections can be a list of value types, embeddable type, or entity collection,
 * this is the example of a list of value types. Collections will always be saved in
 * a new table with the id of its parent for reference.
 */

@Entity
public class HardDisk {

    @Id
    @GeneratedValue
    private long id;

    // Eager fetch loads all the variables
    // Lazy fetch type loads only the first level of variables
    @ElementCollection (fetch = FetchType.EAGER)
    private Set<String> installedOss = new HashSet();

    public Set<String> getInstalledOss() {
        return installedOss;
    }
}
