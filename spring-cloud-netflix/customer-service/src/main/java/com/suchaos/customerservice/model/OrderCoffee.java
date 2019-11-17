package com.suchaos.customerservice.model;

import java.io.Serializable;

public class OrderCoffee implements Serializable {
    private Long orderId;

    private Long coffeeId;

    private static final long serialVersionUID = 1L;

    public Long getOrderId() {
        return orderId;
    }

    public OrderCoffee withOrderId(Long orderId) {
        this.setOrderId(orderId);
        return this;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCoffeeId() {
        return coffeeId;
    }

    public OrderCoffee withCoffeeId(Long coffeeId) {
        this.setCoffeeId(coffeeId);
        return this;
    }

    public void setCoffeeId(Long coffeeId) {
        this.coffeeId = coffeeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", coffeeId=").append(coffeeId);
        sb.append("]");
        return sb.toString();
    }
}