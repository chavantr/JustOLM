package com.mywings.justolm.Model;

/**
 * Created by Tatyabhau Chavan on 5/25/2016.
 */
public class Order {

    private String orderNo;
    private String orderDate;
    private String orderType;
    private boolean actionDelete;
    private boolean confirmDeleted;


    public Order(String orderDate, String orderNo, String orderType, boolean actionDelete, boolean confirmDeleted) {
        this.orderDate = orderDate;
        this.orderNo = orderNo;
        this.orderType = orderType;
        this.actionDelete = actionDelete;
        this.confirmDeleted = confirmDeleted;
    }

    public boolean isActionDelete() {
        return actionDelete;
    }

    public void setActionDelete(boolean actionDelete) {
        this.actionDelete = actionDelete;
    }


    public boolean isConfirmDeleted() {
        return confirmDeleted;
    }

    public void setConfirmDeleted(boolean confirmDeleted) {
        this.confirmDeleted = confirmDeleted;
    }


    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }


}
