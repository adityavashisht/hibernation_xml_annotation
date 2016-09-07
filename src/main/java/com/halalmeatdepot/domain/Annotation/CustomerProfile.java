package com.halalmeatdepot.domain.Annotation;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vashishta on 9/3/16.
 */
@Entity
@Table(name = "CUSTOMER_PROFILE")
public class CustomerProfile {
    @Id
    @Column(name="CUSTOMER_ID",unique=true, nullable=false)
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign",parameters=@Parameter(name="property", value="customerInProfile"))
    private Long id;

    // One to one on customer
    @OneToOne
    @PrimaryKeyJoinColumn
    private Customer customerInProfile;

    @Embedded
    private Phone phone;

    @OneToMany(mappedBy = "customerProfile",cascade = CascadeType.ALL)
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

    public Customer getCustomerInProfile() {
        return customerInProfile;
    }

    public void setCustomerInProfile(Customer customerInProfile) {
        this.customerInProfile = customerInProfile;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }
}
