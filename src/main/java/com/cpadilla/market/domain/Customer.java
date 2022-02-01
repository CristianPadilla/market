package com.cpadilla.market.domain;

import javax.persistence.Column;

public class Customer {


    // not needed atributes for now
//    private String id;
//    private String name;
//    private String surname;
//    private Long phoneNumber;
//    private String address;
//    private String email;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
