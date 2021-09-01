package com.owly.delivery.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    private int addressID;
    private int userId;
    private String addressType; //Consider adding enum to this?
    private String street;
    private String city;
    private String state;
    private int zipCode;
    private String phone;
}
