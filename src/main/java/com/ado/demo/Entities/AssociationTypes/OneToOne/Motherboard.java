package com.ado.demo.Entities.AssociationTypes.OneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Motherboard {

    @Id
    @GeneratedValue
    private long id;
    private int ramSlots;
    private int pciSlots;

    @OneToOne
    private Computer computer;

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRamSlots() {
        return ramSlots;
    }

    public void setRamSlots(int ramSlots) {
        this.ramSlots = ramSlots;
    }

    public int getPciSlots() {
        return pciSlots;
    }

    public void setPciSlots(int pciSlots) {
        this.pciSlots = pciSlots;
    }
}
