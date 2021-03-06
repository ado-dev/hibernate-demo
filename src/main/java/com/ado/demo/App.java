package com.ado.demo;

import com.ado.demo.Entities.AssociationTypes.ManyToMany.PC;
import com.ado.demo.Entities.AssociationTypes.ManyToMany.Player;
import com.ado.demo.Entities.AssociationTypes.OneToMany_ManyToOne.Company;
import com.ado.demo.Entities.AssociationTypes.OneToMany_ManyToOne.Employee;
import com.ado.demo.Entities.AssociationTypes.OneToOne.Computer;
import com.ado.demo.Entities.AssociationTypes.OneToOne.Motherboard;
import com.ado.demo.Entities.Collections.HardDisk;
import com.ado.demo.Entities.EmbeddableTypes.Phone;
import com.ado.demo.Entities.Inheritance.JoinTable.Bike;
import com.ado.demo.Entities.Inheritance.JoinTable.Car;
import com.ado.demo.Entities.Inheritance.SingleTable.FighterJet;
import com.ado.demo.Entities.Inheritance.SingleTable.PassengerJet;
import com.ado.demo.Entities.Inheritance.TablePerClass.Novel;
import com.ado.demo.Entities.Inheritance.TablePerClass.SelfHelp;
import com.ado.demo.Entities.EmbeddableTypes.Person;

import javax.persistence.EntityManager;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityManager entityManager2 = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();


        // I created only one instance of each class for readability and simplicity.
        // These objects are considered transient because they are not yet persisted in DB
        // --------------------------------------------
        Car porsche = new Car();
        porsche.setManufacturer("Porsche");
        porsche.setName("Camaro");
        porsche.setNumberOfSeats(2);

        Bike mountainBike = new Bike();
        mountainBike.setBikeType("Multigear bike");
        mountainBike.setHasRinger(true);
        mountainBike.setName("Mountain Bike");

        // After this code runs, objects will be persisted in the DB including any change done before close()
        entityManager.persist(porsche);
        entityManager.persist(mountainBike);
        // ---------------------------------------------

        Novel robinsonCruso = new Novel();
        robinsonCruso.setType("Adventure");
        robinsonCruso.setName("Robinson Cruso");

        SelfHelp habit = new SelfHelp();
        habit.setTheme("Personality change");
        habit.setName("Power of Habit");

        entityManager.persist(robinsonCruso);
        entityManager.persist(habit);
        // ----------------------------------------------

        PassengerJet passenger = new PassengerJet();
        passenger.setName("Boeing 747");
        passenger.setPassengerCapacity(160);

        FighterJet bomber = new FighterJet();
        bomber.setName("B-22");
        bomber.setType("Bomber");

        entityManager.persist(passenger);
        entityManager.persist(bomber);
        // -----------------------------------------------

        Person ado = new Person();
        Phone smartphone = new Phone();
        smartphone.setManufacturer("Samsung");
        smartphone.setOs("Android");

        Phone dumbphone = new Phone();
        dumbphone.setManufacturer("Nokia");
        dumbphone.setOs("Symbian");

        ado.setName("Ado");
        ado.setOwnPhone(smartphone);
        ado.setWorkPhone(dumbphone);

        entityManager.persist(ado);
        // ------------------------------------------------

        Company google = new Company();
        google.setName("Google");

        Employee smith = new Employee();
        smith.setName("Smith");
        smith.setSalary(1500.00);

        Employee john = new Employee();
        john.setName("John");
        john.setSalary(2500.00);

        google.addEmployee(smith);
        google.addEmployee(john);

        entityManager.persist(google); // cascade will take care of persisting employee objects
        // -------------------------------------------------

        Computer hp = new Computer();
        Motherboard asus = new Motherboard();

        asus.setPciSlots(5);
        asus.setRamSlots(4);
        hp.setManufacturer("HP");
        hp.setType("PC");

        hp.setMotherboard(asus);
        asus.setComputer(hp);

        entityManager.persist(hp);
        entityManager.persist(asus);
        // --------------------------------------------------

        Player player1 = new Player();
        player1.setName("John");

        Player player2 = new Player();
        player2.setName("Smith");

        PC publicPc = new PC();
        publicPc.setManufacturer("HP");
        publicPc.getPlayer().add(player1);
        publicPc.getPlayer().add(player2);

        PC familyPC = new PC();
        familyPC.setManufacturer("ASUS");
        familyPC.getPlayer().add(player1);

        entityManager.persist(publicPc);
        entityManager.persist(familyPC);
        // ---------------------------------------------------

        HardDisk ssd = new HardDisk();
        ssd.setManufacturer("Toshiba");
        ssd.setDateOfProduction(new Date());
        ssd.setDescription(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                "Pellentesque quis efficitur dui, consequat porttitor metus. " +
                "Praesent viverra euismod consectetur. Nullam faucibus rutrum"  +
                "ipsum vitae consectetur. In hac habitasse platea dictumst. " +
                "Phasellus eu lacinia erat. Vivamus fringilla nisi vitae fermentum " +
                "lacinia. Aenean placerat odio quis eros malesuada, eu fringilla dui " +
                "consequat. Nullam viverra ornare dolor, id egestas purus venenatis id."

        );
        ssd.setType("Solid State Drive"); // this will not be persisted beacuse it's Transient
        ssd.setRpm("Not applicable"); // also ignored because it's static
        ssd.getInstalledOss().add("Windows 10");
        ssd.getInstalledOss().add("SomeLinuxDistro");
        ssd.getInstalledOss().add("BSD");

        // This demonstrates Create of CRUD operations
        entityManager.persist(ssd);


        // ----------------------------------------------------






        entityManager.getTransaction().commit();
        entityManager.close();

        // Since the session is closed, and objects persisted, changing them now would be in the
        // detached state, meaning, no changes will be made to the actual data in the DB, unless
        // persisted in the future transaction
        // porsche.setName("CAYENNE"); // won't reflect in the DB

        entityManager2.getTransaction().begin();

        // CRUD OPERATIONS ------------------------------------
        // ----------------------------------------------------
        // CREATE (persist) data is already demonstrated above

        // READ
        HardDisk ssdData = entityManager2.find(HardDisk.class, Long.valueOf(17)); // id's value type is long

        System.out.println(
                "SSD DATA \n"
                + "Manufacturer:\t" + ssdData.getManufacturer() + "\n"
                + "Installed OSs:\t" + ssdData.getInstalledOss() + "\n" // all values loaded because of EAGER fetch type
                + "Type:\t" + ssdData.getType() + "\n" // this is null because of @Transient
                + "Production date:\t" + ssdData.getDateOfProduction() + "\n"
                + "Description:\t" + ssdData.getDescription() + "\n"
        );

        // UPDATE
        // update is done simply by changing the current value and commiting the change
        ssdData.getInstalledOss().add("Solaris");

        // only the most current value will be the update one
        ssdData.setManufacturer("Western Digital");
        ssdData.setManufacturer("Toshiba"); // this one

        System.out.println(
                "SSD DATA \n"
                        + "Manufacturer:\t" + ssdData.getManufacturer() + "\n" // Toshiba
                        + "Installed OSs:\t" + ssdData.getInstalledOss() + "\n"
                        + "Type:\t" + ssdData.getType() + "\n"
                        + "Production date:\t" + ssdData.getDateOfProduction() + "\n"
                        + "Description:\t" + ssdData.getDescription() + "\n"
        );

        // DELETE
        Bike bike = entityManager2.find(Bike.class, Long.valueOf(2));
        entityManager2.remove(bike);

        entityManager2.getTransaction().commit();
        entityManager2.close();
    }
}
