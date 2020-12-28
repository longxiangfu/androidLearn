package com.example.nettest;

import java.io.Serializable;

public class Order implements Serializable {
    /**
     *
     */
    private Long id;

    /**
     * 订单编号
     */
    private String orderSn;

    /**
     * 用户id
     */
    private Long memberId;


    /**
     * 订单状态
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
