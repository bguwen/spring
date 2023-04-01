package com.hngc.entity;


public class User {

    private Integer id;
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


    /**
     * 获取
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     *
     * @return role
     */
    public int getRole() {
        return role;
    }

    /**
     * 设置
     *
     * @param role
     */
    public void setRole(int role) {
        this.role = role;
    }

    /**
     * 获取
     *
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置
     *
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "User{id = " + id + ", username = " + username + ", password = " + password + ", role = " + role + ", sex = " + sex + ", phone = " + phone + "}";
    }
}
