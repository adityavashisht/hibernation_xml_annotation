package com.hmd.services;

/**
 * Created by vashishta on 9/1/16.
 */

import com.halalmeatdepot.annotation.*;
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
public class OrderTestAnnotation {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    @Rollback(value = false)
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Siji2");
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
        customer.setLastName("Chen2");
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
        customer.setFirstName("Another");
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
    @Rollback(value = false)
    public void testAddOrderItemToExistOrder(){
        Session session = sessionFactory.getCurrentSession();
        Order order = session.load(Order.class, 1L);

        OrderItem orderItem = new OrderItem();
        order.addOrderItem(orderItem);
        orderItem.setGiftWrap(true);
        orderItem.setQuantity(2);
        session.save(order);
    }


    @Test
    public void testGetCustomer() {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.load(Customer.class, 1L);

        CustomerProfile customerProfile = customer.getCustomerProfile();
        System.out.println(customerProfile);


    }

    @Test
    public void testGetOrder(){
        Session session =sessionFactory.getCurrentSession();
        Order order = session.load(Order.class,1L);
        System.out.println(order);
    }

}
