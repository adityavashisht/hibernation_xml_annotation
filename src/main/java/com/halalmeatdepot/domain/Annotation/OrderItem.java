package com.halalmeatdepot.domain.Annotation;



/**
 * Created by vashishta on 9/1/16.
 */
public class OrderItem {

    private Long id;
    private Order order;
    private boolean giftWrap;
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isGiftWrap() {
        return giftWrap;
    }

    public void setGiftWrap(boolean giftWrap) {
        this.giftWrap = giftWrap;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;

        OrderItem orderItem = (OrderItem) o;

        if (isGiftWrap() != orderItem.isGiftWrap()) return false;
        if (getId() != null ? !getId().equals(orderItem.getId()) : orderItem.getId() != null) return false;
        if (getOrder() != null ? !getOrder().equals(orderItem.getOrder()) : orderItem.getOrder() != null) return false;
        return getQuantity() != null ? getQuantity().equals(orderItem.getQuantity()) : orderItem.getQuantity() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getOrder() != null ? getOrder().hashCode() : 0);
        result = 31 * result + (isGiftWrap() ? 1 : 0);
        result = 31 * result + (getQuantity() != null ? getQuantity().hashCode() : 0);
        return result;
    }
}
