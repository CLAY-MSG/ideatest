package com.itcast.domain;

/**
 * @Author:CLAY
 * @Date: 2020/1/8
 * @Time: 13:33
 * @Version: 1.1
 */
public class LoginUser {
    private int id;
    private String username;
    private String password;

    public LoginUser() {
    }

    public LoginUser(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
