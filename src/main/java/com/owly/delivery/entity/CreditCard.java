package com.owly.delivery.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class CreditCard implements Serializable {
    private static final long serialVersionUID = 8123440534986494123L;

    @Id
    private long cardNumber;
    private int userID;
    private String firstName;
    private Date expirationDate;
    private String lastName;
    private String zipCode;
    private String address;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
            "cardNumber=" + cardNumber +
            ", userID=" + userID +
            ", firstName='" + firstName + '\'' +
            ", expirationDate=" + expirationDate +
            ", lastName='" + lastName + '\'' +
            ", zipCode='" + zipCode + '\'' +
            ", address='" + address + '\'' +
            '}';
    }
}
