package com.msg.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/15 11:49
 */
public class JpaUtils {
    private static EntityManagerFactory entityManagerFactory;
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
    }

    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
}
