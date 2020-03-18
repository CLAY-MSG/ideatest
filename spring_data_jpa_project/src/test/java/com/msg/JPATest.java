package com.msg;

import com.msg.domain.Customer;
import com.msg.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/13 21:23
 */
public class JPATest {

    @Test
    public void testSave(){
        EntityManagerFactory myJpa = Persistence.createEntityManagerFactory("myJpa");
        EntityManager entityManager = myJpa.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = new Customer();
        customer.setCustName("特工008");
        customer.setCustIndustry("特工");
        customer.setCustAddress("帝都");
        customer.setCustLevel("一级");
        entityManager.persist(customer);
        transaction.commit();
        entityManager.close();
        myJpa.close();
    }

    @Test
    public void testQuery(){
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = entityManager.getReference(Customer.class, 1l);
        customer.setCustLevel("二级");
        entityManager.remove(customer);

        transaction.commit();
        entityManager.close();
    }
}
