package com.ado.demo.Entities.Collections;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * DEMONSTRATES ADDING COLLECTIONS TO ENTITIES
 * Collections can be a list of value types, embeddable type, or entity collection,
 * this is the example of a list of value types. Collections will always be saved in
 * a new table with the id of its parent for reference and named parent_child by default.
 */

@Entity
public class HardDisk {

    @Id
    @GeneratedValue
    private long id;
    private String manufacturer;

    // @Temporal allows us to specify whether the Date object will contain only
    // DATE or TIME, or if left out both date and timestamp will be shown in DB
    @Temporal (TemporalType.DATE)
    private Date dateOfProduction;

    // Lob is used where long strings or byte streams are to be stored in a column
    // it automatically chooses between a Clob (long string) or Blob (byte stream)
    @Lob
    private String description;

    // Transient or static values will be ingored by Hibernate
    @Transient
    private String type; // ignored
    static private String rpm; // ignored

    // Eager fetch loads all the variables
    // Lazy fetch type loads only the first level of variables
    @ElementCollection (fetch = FetchType.EAGER)
    @JoinTable (name = "HD_OSs") // changes table name of the collection
    private Set<String> installedOss = new HashSet();

    public Set<String> getInstalledOss() {
        return installedOss;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getDateOfProduction() {
        return dateOfProduction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateOfProduction(Date dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static String getRpm() {
        return rpm;
    }

    public static void setRpm(String rpm) {
        HardDisk.rpm = rpm;
    }


}
