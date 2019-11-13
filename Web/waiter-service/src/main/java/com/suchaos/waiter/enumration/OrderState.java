package com.suchaos.waiter.enumration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * 订单状态
 *
 * @author suchao
 * @date 2019/11/13
 */
public enum OrderState {

    /**
     * init 初始阶段
     */
    INIT(0),

    /**
     * 已支付
     */
    PAID(1),
    BARWING(2),
    BREWED(3),
    TAKEN(4),
    /**
     * 已取消
     */
    CANCELLED(5);

    Integer state;

    OrderState(Integer state) {
        this.state = state;
    }

    @JsonValue
    public Integer getState() {
        return this.state;
    }

    @JsonCreator
    public static OrderState fromValue(Integer state) {
        OrderState[] states = OrderState.values();
        for (OrderState orderState : states) {
            if (orderState.getState().equals(state)) {
                return orderState;
            }
        }
        return null;
    }
}
