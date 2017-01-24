package com.hmd.services;

import com.halalmeatdepot.annotation.Order;
import com.halalmeatdepot.annotation.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sjchen on 1/23/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// Multiple locations can be specified with comma delimited values
@ContextConfiguration(locations = {
        "/storefront.xml"
})
@Transactional
public class EageFetchingTest {

    @Autowired
    SessionFactory sessionFactory;


    @Test
    public void testGetOrder() {
        Session session = sessionFactory.openSession();
        Order order = session.load(Order.class, 1L);
        List<OrderItem> orderItems = order.getOrderItemSet();
        //no issue will be here when accessing collection as the session still open
        System.out.println(order.getOrderItemSet());
        session.close();
    }


}
