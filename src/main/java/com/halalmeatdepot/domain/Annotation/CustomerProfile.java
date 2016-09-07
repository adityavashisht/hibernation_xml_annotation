package com.halalmeatdepot.domain.Annotation;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vashishta on 9/3/16.
 */
@Entity
@Table
public class CustomerProfile {
    @Id
    @SequenceGenerator(name="CUSTOMER_SEQ",sequenceName = "CUSTOMER_SEQ" )
    @GenericGenerator(name="CUSTOMER_SEQ", strategy="foreign")
    @Column(name="CUSTOMER_ID", nullable=false)
    private Long id;
    // One to one on customer
    private Customer customer;

    private Phone phone;

    private Set<Address> addressSet = new HashSet<>();

    public void addAddress(Address address) {
        address.setCustomerProfile(this);
        getAddressSet().add(address);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }



    public Phone getPhone() {
        return phone;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

}
