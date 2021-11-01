package edu.eci.cvds.entities;

import java.io.Serializable;

public class User implements Serializable{
    private int id;
    private String name;
    private String password;
    private String email;
    private boolean status;
    private UserType userType;

    public User(String name, String password, String email, boolean status, UserType userType){
        this.name = name;
        this.password = password;
        this.email = email;
        this.status = status;
        this.userType = userType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public boolean getStatus() {
        return status;
    }

    public UserType getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        return "User{id=" + id + " name=" + name + " password=" + password + " email=" + email + " status=" + status + "usertype= " + userType.toString() + " }";
    }
}
