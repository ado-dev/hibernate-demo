package com.ado.demo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Adnan on 28-Apr-17.
 */
public class JPAUtil {
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("PERSISTENCE");
        }

        return factory;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}
