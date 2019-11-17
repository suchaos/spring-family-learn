package com.suchaos.customerservice.model;

import com.suchaos.customerservice.enumration.OrderState;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable {
    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String customer;

    private OrderState state;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public Order withId(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Order withCreateTime(LocalDateTime createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public Order withUpdateTime(LocalDateTime updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getCustomer() {
        return customer;
    }

    public Order withCustomer(String customer) {
        this.setCustomer(customer);
        return this;
    }

    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    public OrderState getState() {
        return state;
    }

    public Order withState(OrderState state) {
        this.setState(state);
        return this;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", customer=").append(customer);
        sb.append(", state=").append(state);
        sb.append("]");
        return sb.toString();
    }
}