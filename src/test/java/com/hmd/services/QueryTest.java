package com.hmd.services;

import com.halalmeatdepot.annotation.Customer;
import com.halalmeatdepot.annotation.CustomerProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sjchen on 1/24/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// Multiple locations can be specified with comma delimited values
@ContextConfiguration(locations = {
        "/storefront.xml"
})
@Transactional(readOnly = true)
public class QueryTest {
    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void testList(){
        Session session = sessionFactory.openSession();
        //the Customer is the class name, case sensitive
        Query query = session.createQuery("from Customer");
        List<Customer> customers= query.list();
        query=session.createQuery("from Customer c ");
        query.setFirstResult(0);
        query.setMaxResults(10);
        List<Customer> customersPaged=query.getResultList();
        System.out.println(customersPaged);

        query=session.createQuery("from Customer where lastName = ?");
        query.setParameter(0,"Chen");
        Customer customerOne = (Customer)query.uniqueResult();
        System.out.println(customerOne);
        session.close();
        //one to one mapping will eager fetch by default
        CustomerProfile cp=customers.get(1).getCustomerProfile();
        System.out.println(cp);
    }
}
