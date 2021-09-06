package com.owly.delivery.entity;

import java.sql.Timestamp;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "Orders")
public class Orders implements Serializable {
    private static final long serialVersionUID = 145823L;

    @Id
    private int orderId;
    private int userID;
    private String recipientName;
    private String fromAddress;
    private String toAddress;
    private Timestamp actualPickUpTime;
    private Timestamp createTime;
    private Timestamp departTime;
    private Timestamp desiredPickedUpTime;
    private Timestamp deliveryTime;
    private double totalCost;
    private String paymentStatus;
    private String Review;
    private String orderStatus;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public Timestamp getActualPickUpTime() {
        return actualPickUpTime;
    }

    public void setActualPickUpTime(Timestamp actualPickUpTime) {
        this.actualPickUpTime = actualPickUpTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Timestamp departTime) {
        this.departTime = departTime;
    }

    public Timestamp getDesiredPickedUpTime() {
        return desiredPickedUpTime;
    }

    public void setDesiredPickedUpTime(Timestamp desiredPickedUpTime) {
        this.desiredPickedUpTime = desiredPickedUpTime;
    }

    public Timestamp getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Timestamp deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }


    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", userID=" + userID +
                ", recipientName='" + recipientName + '\'' +
                ", fromAddress='" + fromAddress + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", actualPickUpTime=" + actualPickUpTime +
                ", createTime=" + createTime +
                ", departTime=" + departTime +
                ", desiredPickedUpTime=" + desiredPickedUpTime +
                ", deliveryTime=" + deliveryTime +
                ", totalCost=" + totalCost +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", Review='" + Review + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}