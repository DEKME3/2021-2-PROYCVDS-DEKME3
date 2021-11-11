package edu.eci.cvds.ManageBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.services.client.MyBatisPrueba;

@SuppressWarnings("deprecation")
@SessionScoped
@ManagedBean(name = "offerBean")
public class offerBean {

    public int updateId;
    public String name;
    public int category;
    public String description;
    public Date creationDate;
    public String status;
    public Date modificationDate;
    public String newName;
    public Category Newcategory;
    public String newDescription;
    public String newStatus;
    public static List<Offer> offers = new ArrayList<>();

    public offerBean() {
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        offerBean.offers = offers;
    }

    public void insertOffer() {
        if (MyBatisPrueba.validaInsertOfertas(5)) {
            setCreationDate(new Date());
            setModificationDate(new Date());
            Offer newOffer = new Offer(name, description, new Date(), getStatus(), new Date());
            MyBatisPrueba.insertarOferta(newOffer, category, 5);
            offers.add(newOffer);
        }
    }

    public void updateOffer(){
        if(validarStatus()) {
            setModificationDate(new Date());
            MyBatisPrueba.updateOferta(updateId, newStatus);
        }
    }

    private boolean validarStatus() {
        if(this.status.equals("ACTIVA") || this.status.equals("EN PROCESO") || this.status.equals("RESUELTA") || this.status.equals("CERRADA")) {
            return true;
        }else {
            return false;
        }
    }
}
