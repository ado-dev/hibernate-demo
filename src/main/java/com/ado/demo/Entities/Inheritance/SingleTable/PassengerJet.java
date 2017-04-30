package com.ado.demo.Entities.Inheritance.SingleTable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Adnan on 28-Apr-17.
 */

@Entity
@DiscriminatorValue(value = "Passenger") // this value will be used in Discriminator column to identify this class
public class PassengerJet extends Aircraft {

    private int passengerCapacity;

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
