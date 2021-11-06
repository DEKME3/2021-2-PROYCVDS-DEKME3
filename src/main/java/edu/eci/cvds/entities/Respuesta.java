package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.Date;

public class Respuesta implements Serializable{
    private int id;
    private String name;
    private String comments_;
    private Date creationDate;
    private int Offer;
    private int need;

    public Respuesta(String name, String comments, Date creationDate, int offer, int need){
        this.name = name;
        this.comments_ = comments;
        this.creationDate = creationDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setcomments_(String comments) {
        this.comments_ = comments;
    }

    public void setcreationdate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setOffer(int offers) {
        this.Offer = offers;
    }

    public void setNeed(int needs) {
        this.need = needs;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getcomments() {
        return comments_;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getoffer() {
        return Offer;
    }

    public Date getneed() {
        return need;
    }

    @Override
    public String toString() {
        return "Respuesta{id=" + id + " name=" + name + " Comment=" + comments_ + " creation date=" + creationDate + " Offer=" + Offer + "Need= " + need + " }";
    }
}