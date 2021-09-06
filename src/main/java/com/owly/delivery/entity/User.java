package com.owly.delivery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 2652327633296064143L;


    @Id
    @GeneratedValue
    private int userId;

    @Column(unique = true)
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private boolean enabled;


    @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Address> addressListList;

    public List<Address> getAddressListList() {
        return addressListList;
    }

    public void setAddressListList(List<Address> addressListList) {
        this.addressListList = addressListList;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;

    }
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
            "userId=" + userId +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
    }


//    @Override
//    public String toString() {
//        return "User{" +
//                "email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", enabled=" + enabled +
//                '}';
//    }
}
