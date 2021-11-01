package edu.eci.cvds.entities;

import java.io.Serializable;

public class User implements Serializable{
    private int id;
    private String name;
    private String description;
    private Date creationDate;
    private String status;
    private Date modification;

    public Category(String name, String description, Date creationDate, String status){
        this.name = name;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
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

    public void setcreationdate(String creationdate) {
        this.creationDate = creationdate;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setUserType(UserType modification) {
        this.modification = modification;
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

    public String getCreationDate() {
        return creationDate;
    }

    public boolean getStatus() {
        return status;
    }

    public UserType getModification() {
        return modification;
    }

    @Override
    public String toString() {
        return "User{id=" + id + " name=" + name + " description=" + description + " creation date=" + creationDate + " status=" + status + "modification= " + modification + " }";
    }
}