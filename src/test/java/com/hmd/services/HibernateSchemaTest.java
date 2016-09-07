package com.hmd.services;

import com.halalmeatdepot.domain.annotation.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vashishta on 8/30/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
// Multiple locations can be specified with comma delimited values
@ContextConfiguration(locations = {
        "/storefront.xml"
})

@Transactional
public class HibernateSchemaTest {

    @Autowired
    private SessionFactory sessionFactory;


    @Test
    @Rollback( value = false)
    public void testCreate() {
        Session session = sessionFactory.getCurrentSession();

        Customer customer = new Customer();
        customer.setEmail("aditya@indasil.com");

        session.save(customer);
    }
}
