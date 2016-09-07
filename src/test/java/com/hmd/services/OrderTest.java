package com.hmd.services;

/**
 * Created by vashishta on 9/1/16.
 */

import com.halalmeatdepot.domain.Annotation.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by vashishta on 8/30/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
// Multiple locations can be specified with comma delimited values
@ContextConfiguration(locations = {
        "/storefront.xml"
})

@Transactional
public class OrderTest {

    @Autowired
    private SessionFactory sessionFactory;

/*
    @Test
    @Rollback(value = false)
    public void testOrder() {

        Order order = new Order();
        order.setCreateDate(LocalDateTime.now());

        Phone phone = new Phone();
        phone.setHome("1121212121");
        phone.setMobile("2324232423432");
        phone.setWork("13234343");

        CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setPhone(phone);


        Customer customer = new Customer();
        customer.setEmail("aditya@indasil.com");
        customer.setFirstName("Aditya");
        customer.setLastName("Vashisht");


        customer.setCustomerProfile(customerProfile);
        customerProfile.setCustomer(customer);

        Address shipping = new Address();
        shipping.setCustomer(customer);
        shipping.setAddressType(AddressType.SHIPPING);
        shipping.setCity("Chantilly");
        shipping.setStreet("Test Street");
        shipping.setCreateDate(new Date());
        customer.addAddress(shipping);


        Address billing = new Address();
        billing.setCustomer(customer);
        billing.setAddressType(AddressType.BILLING);
        billing.setCity("Billing City");
        billing.setStreet("Test Street Billing");
        billing.setCreateDate(new Date());
        customer.addAddress(billing);


        Session s = sessionFactory.getCurrentSession();
       /* s.setHibernateFlushMode(FlushMode.MANUAL);

        s.save(customer);

         s.flush();*/

/*
        order.setCustomer(customer);


        OrderItem orderItem = new OrderItem();
        orderItem.setGiftWrap(true);
        // Tell the child who the parent is
        orderItem.setOrder(order);
        orderItem.setQuantity(2);


        // Add the child to the collection of children
        order.addItem(orderItem);

        OrderItem orderItemTwo = new OrderItem();
        orderItemTwo.setGiftWrap(true);
        // Tell the child who the parent is
        orderItemTwo.setOrder(order);
        orderItemTwo.setQuantity(2);


        // Add the child to the collection of children
        order.addItem(orderItemTwo);


        s.save(order);

        s.save(customerProfile);


    }
*/
    @Test
    @Rollback(value = false)
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Siji");
        customer.setLastName("Chen");
        customer.setEmail("chensiji1989@gmail.com");
        CustomerProfile customerProfile = new CustomerProfile();
        customer.setCustomerProfile(customerProfile);

        Address shipping = new Address();
        shipping.setStreet("Diligence ct");
        shipping.setCity("Aldie");
        shipping.setCreateDate(new Date());
        shipping.setAddressType(AddressType.SHIPPING);
        shipping.setPrimary(true);
        customerProfile.addAddress(shipping);

        Address billing = new Address();
        billing.setStreet("Constitution ave");
        billing.setCity("DC");
        billing.setCreateDate(new Date());
        billing.setAddressType(AddressType.BILLING);
        billing.setPrimary(false);
        customerProfile.addAddress(billing);

        Phone phone = new Phone();
        phone.setHome("240-586-2693");
        phone.setMobile("917-621-7682");

        customerProfile.setPhone(phone);
        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
    }

    @Test
    @Rollback(value = false)
    public void testCreateCustomerAnother() {
        Customer customer = new Customer();
        customer.setFirstName("Bill");
        customer.setLastName("Chen");
        customer.setEmail("billchen@gmail.com");
        CustomerProfile customerProfile = new CustomerProfile();
        customer.setCustomerProfile(customerProfile);

        Address shipping = new Address();
        shipping.setStreet("Diligence ct");
        shipping.setCity("Aldie");
        shipping.setCreateDate(new Date());
        shipping.setAddressType(AddressType.SHIPPING);
        shipping.setPrimary(true);
        customerProfile.addAddress(shipping);

        Address billing = new Address();
        billing.setStreet("Constitution ave");
        billing.setCity("DC");
        billing.setCreateDate(new Date());
        billing.setAddressType(AddressType.BILLING);
        billing.setPrimary(false);
        customerProfile.addAddress(billing);

        Phone phone = new Phone();
        phone.setHome("240-586-2693");
        phone.setMobile("917-621-7682");

        customerProfile.setPhone(phone);
        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
    }

    @Test
    @Rollback(value = false)
    public void testCreateCustomerAndOrder() {
        Customer customer = new Customer();
        customer.setFirstName("Siji");
        customer.setLastName("Chen");
        customer.setEmail("chensiji1989@gmail.com");
        CustomerProfile customerProfile = new CustomerProfile();
        customer.setCustomerProfile(customerProfile);

        Address shipping = new Address();
        shipping.setStreet("Diligence ct");
        shipping.setCity("Aldie");
        shipping.setCreateDate(new Date());
        shipping.setAddressType(AddressType.SHIPPING);
        shipping.setPrimary(true);
        customerProfile.addAddress(shipping);

        Address billing = new Address();
        billing.setStreet("Constitution ave");
        billing.setCity("DC");
        billing.setCreateDate(new Date());
        billing.setAddressType(AddressType.BILLING);
        billing.setPrimary(false);
        customerProfile.addAddress(billing);

        Phone phone = new Phone();
        phone.setHome("240-586-2693");
        phone.setMobile("917-621-7682");

        customerProfile.setPhone(phone);

        Order order = new Order();
        OrderItem orderItem = new OrderItem();
        customer.addOrder(order);
        order.addOrderItem(orderItem);
        orderItem.setGiftWrap(true);
        orderItem.setQuantity(1);
        order.setCreateDate(LocalDateTime.now());

        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
    }
    @Test
    @Rollback(value = false)
    public void testAddOrder(){
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.load(Customer.class, 2L);

        Order order = new Order();
        OrderItem orderItem = new OrderItem();
        customer.addOrder(order);
        order.addOrderItem(orderItem);
        orderItem.setGiftWrap(true);
        orderItem.setQuantity(1);
        order.setCreateDate(LocalDateTime.now());
        session.save(customer);
    }
    @Test
    public void testGetCustomer() {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.load(Customer.class, 1L);

        CustomerProfile customerProfile = customer.getCustomerProfile();
        System.out.println(customerProfile);


    }

}
