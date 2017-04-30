package com.ado.demo.Entities.Inheritance.JoinTable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn (name = "bike_id")
public class Bike extends Vehicle {

    private String bikeType;
    private boolean hasRinger;

    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public boolean isHasRinger() {
        return hasRinger;
    }

    public void setHasRinger(boolean hasRinger) {
        this.hasRinger = hasRinger;
    }
}
