package com.halalmeatdepot.domain.xml;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vashishta on 8/30/16.
 */

public class Customer {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private CustomerProfile customerProfile;

    private List<Order> orderList=new ArrayList<>();

    public void addOrder(Order order){
        order.setCustomer(this);
        orderList.add(order);
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(CustomerProfile customerProfile) {
        customerProfile.setCustomer(this);
        this.customerProfile = customerProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
