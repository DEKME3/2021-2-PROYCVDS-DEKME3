package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable{
    private int id;
    private String name;
    private String description;
    private Date creationDate;
    private String status;
    private Date modificationDate;

    public Category(String name, String description, Date creationDate, String status, Date modification){
        this.name = name;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
        this.modificationDate = modification;
    }

    public Category(int id, String name, String description, Date creationDate, String status, Date modification){
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
        this.modificationDate = modification;
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

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
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

    public Date getModificationDate() {
        return modificationDate;
    }

    @Override
    public String toString() {
        return "Category{id=" + id + " name=" + name + " description=" + description + " creation date=" + creationDate + " status=" + status + "modification= " + modificationDate + " }";
    }
}