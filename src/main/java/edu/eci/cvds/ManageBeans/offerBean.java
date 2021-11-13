package edu.eci.cvds.ManageBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.SessionScoped;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;
import edu.eci.cvds.services.CategoryServices;
import edu.eci.cvds.services.OfferServices;
import edu.eci.cvds.services.ServicesFactory;
import edu.eci.cvds.services.UserServices;
import edu.eci.cvds.services.client.MyBatisPrueba;

@SuppressWarnings("deprecation")
@SessionScoped
@ManagedBean(name = "offerBean")
public class offerBean {

    public int updateId;
    public String name;
    public String category;
    public String description;
    public Date creationDate;
    public String status;
    public Date modificationDate;
    public String newName;
    public Category Newcategory;
    public String newDescription;
    public String newStatus;
    public List<Offer> offers = new ArrayList<>();
    private OfferServices offerServices = ServicesFactory.getInstance().getOfferServices();
    private UserServices userServices = ServicesFactory.getInstance().getUserServices();
    private CategoryServices categoryServices = ServicesFactory.getInstance().getCategoryServices();

    public offerBean() {
    }

    @PostConstruct
    public void loadOffers(){
        ArrayList<Offer> offersList;
        try {
            offersList = offerServices.getOfertas();
            offers.addAll(offersList);
        } catch (ExcepcionesSolidaridad e) {
            e.printStackTrace();
        }
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

    public void setCategory(String category) {
        this.category = category;
    }

    public void setNewcategory(Category newcategory) {
        Newcategory = newcategory;
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

    public String getCategory() {
        return category;
    }

    public Category getNewcategory() {
        return Newcategory;
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
        this.offers = offers;
    }

    public void insertOffer() {
        if (MyBatisPrueba.validaInsertOfertas(5)) {
            setCreationDate(new Date());
            setModificationDate(new Date());
            Offer newOffer = new Offer(name, description, new Date(), getStatus(), new Date());
            try {
                Subject currentUser = SecurityUtils.getSubject();
                String nombreUsuario = (String) currentUser.getSession().getAttribute("Nombre");
                newOffer.setUsuario(userServices.getUser(nombreUsuario));
                int idUsuario = userServices.getUser(nombreUsuario).getId();
                int idCategoria = categoryServices.getCategoryIdByName(category);
                offerServices.insertarOferta(newOffer, idCategoria, idUsuario);
                offers.clear();
                loadOffers();
            } catch (ExcepcionesSolidaridad e) {
                e.printStackTrace();
            }
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
