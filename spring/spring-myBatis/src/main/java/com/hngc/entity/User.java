package com.hngc.entity;

import lombok.Data;

@Data
public class User {

    private int id;
    private String username;

    private String password;

    private int role;

    private String sex;

    private String phone;

    public User() {
    }

    public User(int id, String username, String password, int role, String sex, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.sex = sex;
        this.phone = phone;
    }


}
