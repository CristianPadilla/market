package com.cpadilla.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    private String id;

    private String name;
    private String surname;

    @Column(name = "phone_number")
    private Long phoneNumber;

    private String address;
    private String email;

    @OneToMany(mappedBy = "customerEntity")
    private List<PurchaseEntity> purchaseEntities;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
