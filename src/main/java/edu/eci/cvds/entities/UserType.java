package edu.eci.cvds.entities;

import java.io.Serializable;

public class UserType implements Serializable{
    
    private int id;
    private String name;
    private String description;

    public UserType(int id, String name, String description){

    this.id = id;
    this.name = name;
    this.description = description;
    }
}
