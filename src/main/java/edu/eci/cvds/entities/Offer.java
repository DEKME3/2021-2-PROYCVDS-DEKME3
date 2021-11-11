package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.Date;

public class Offer implements Serializable{
    private int id;
    private String name;
    private Category category;
    private String description;
    private Date creationDate;
    private String status;
    private Date modificationDate;
    private User usuario;

    public Offer(String name, String description, Date creationDate, String status, Date modificationDate){
        this.name = name;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    public Offer() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setcreationdate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory(){
        return category;
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

    public User getUsuario() {
        return usuario;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    @Override
    public String toString() {
        return "Category{id=" + id + " name=" + name + "Category" + category + " description=" + description + " creation date=" + creationDate + " status=" + status + "modificationDate= " + modificationDate + " }";
    }
}