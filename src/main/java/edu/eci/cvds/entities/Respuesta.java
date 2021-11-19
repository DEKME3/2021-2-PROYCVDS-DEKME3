package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.Date;

public class Respuesta implements Serializable{
    private int id;
    private String name;
    private String comments;
    private Date creationDate;
    private Offer offer;
    private Need need;

    public Respuesta(String name, String comments, Date creationDate, Offer offer) {
        this.name = name;
        this.comments = comments;
        this.creationDate = creationDate;
        this.offer = offer;
    }

    public Respuesta(String name, String comments, Date creationDate, Need need) {
        this.name = name;
        this.comments = comments;
        this.creationDate = creationDate;
        this.need = need;
    }

    public Respuesta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Need getNeed() {
        return need;
    }

    public void setNeed(Need need) {
        this.need = need;
    }

    @Override
    public String toString() {
        return "Respuesta{id=" + id + " name=" + name + " Comment=" + comments + " creation date=" + creationDate + " }";
    }
}