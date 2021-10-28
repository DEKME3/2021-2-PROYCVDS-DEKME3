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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "UserType{id=" + id + " name=" + name + " description=" + description + " }";
    }
}
