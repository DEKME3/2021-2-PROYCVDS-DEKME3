package edu.eci.cvds.entities;

import java.io.Serializable;

public class User implements Serializable{
    private int id;
    private String name;
    private String password;
    private String email;
    private boolean status;
    private UserType userType;

    public User(UserType userType, String name, String password, String email, boolean status){
        this.name = name;
        this.password = password;
        this.email = email;
        this.status = status;
        this.userType = userType;
    }
}
