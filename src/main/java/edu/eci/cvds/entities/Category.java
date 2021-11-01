package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable{
    private int id;
    private String name;
    private String description;
    private Date creationDate;
    private String status;
    private Date modification;

    public Category(String name, String description, Date creationDate, String status, Date modification){
        this.name = name;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
        this.modification = modification;
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
        this.creationDate = creationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserType(Date modification) {
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

    public Date getCreationDate() {
        return creationDate;
    }

    public String getStatus() {
        return status;
    }

    public Date getModification() {
        return modification;
    }

    @Override
    public String toString() {
        return "Category{id=" + id + " name=" + name + " description=" + description + " creation date=" + creationDate + " status=" + status + "modification= " + modification + " }";
    }
}