package com.itcast.domain;

/**
 * @author CLAY
 * @data 2020/1/722:42
 * @version 1.1
 */
public class User {
    private int id;
    private String username;
    private String address;
    private String email;
    private String gender;
    private int age;
    private int qq;

    public User() {
    }

    public User(int id, String username, String address, String email, String gender, int age, int qq) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.qq = qq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", qq=" + qq +
                '}';
    }
}
