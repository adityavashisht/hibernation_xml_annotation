package com.halalmeatdepot.annotation;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;


/**
 * Created by vashishta on 8/30/16.
 */
@Entity
@Table(name="CUSTOMER_ORDER")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CUSTOMER_ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID",nullable=false,unique=true)
    private Customer customer;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL
            ,fetch = FetchType.EAGER
    )
    private List<OrderItem> orderItemSet= new ArrayList<>();

    public void addOrderItem(OrderItem orderItem){
        orderItem.setOrder(this);
        getOrderItemSet().add(orderItem);
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }



    public List<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }

    public void setOrderItemSet(List<OrderItem> orderItemSet) {
        this.orderItemSet = orderItemSet;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        return getId() != null ? getId().equals(order.getId()) : order.getId() == null;

    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
