package edu.eci.cvds.ManageBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.services.client.MyBatisPrueba;



@SessionScoped
@ManagedBean(name = "offerBean")
public class offerBean {

    public int updateId;
    public String name;
    public Category category;
    public String description;
    public Date creationDate;
    public String status;
    public Date modificationDate;
    public String newName;
    public Category Newcategory;
    public String newDescription;
    public String newStatus;
    public List<Offer> offers = new ArrayList<>();

    public offerBean() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public void setUpdateId(int updateId) {
        this.updateId = updateId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public String getNewName() {
        return newName;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public int getUpdateId() {
        return updateId;
    }

    public void insertOffer(){
        Offer newOffer = new Offer(name, description, new Date(), status, new Date());
        MyBatisPrueba.insertarOferta(newOffer);
        offers.add(newOffer);
    }

    public void updateOffer(){
        MyBatisPrueba.updateOferta(newStatus);
    }
}
