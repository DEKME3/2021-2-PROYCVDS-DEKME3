package edu.eci.cvds.ManageBeans;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.SessionScoped;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;
import edu.eci.cvds.services.CategoryServices;
import edu.eci.cvds.services.OfferServices;
import edu.eci.cvds.services.ServicesFactory;
import edu.eci.cvds.services.UserServices;

import org.primefaces.PrimeFaces;
import org.primefaces.model.chart.PieChartModel;

@SuppressWarnings("deprecation")
@SessionScoped
@ManagedBean(name = "offerBean")

public class offerBean {

    public int updateId;
    public String updateStatus;
    public String name;
    public String category;
    public String description;
    public Date creationDate;
    public String status;
    public Date modificationDate;
    public List<Offer> offers = new ArrayList<>();
    public List<Category> categorias = new ArrayList<>();
    private OfferServices offerServices = ServicesFactory.getInstance().getOfferServices();
    private UserServices userServices = ServicesFactory.getInstance().getUserServices();
    private CategoryServices categoryServices = ServicesFactory.getInstance().getCategoryServices();
    private PieChartModel pieModel;

    public offerBean() {
    }

    @PostConstruct
    public void loadOffers(){
        ArrayList<Offer> offersList;
        ArrayList<Category> categoriesList;
        try {
            offersList = offerServices.getOfertas();
            offers.addAll(offersList);
            categoriesList = categoryServices.getCategories();
            categorias.addAll(categoriesList);
            createPieModel();
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

    public void setUpdateId(int updateId) {
        this.updateId = updateId;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }

    public void setCategorias(List<Category> categorias) {
        this.categorias = categorias;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public PieChartModel getPieModel() {
        return pieModel;
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

    public int getUpdateId() {
        return updateId;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public String getUpdateStatus() {
        return updateStatus;
    }

    public List<Category> getCategorias() {
        return categorias;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public void insertOffer() {
        Offer newOffer = new Offer(name, description, new Date(), status, new Date());
        Subject currentUser = SecurityUtils.getSubject();
        String nombreUsuario = (String) currentUser.getSession().getAttribute("Nombre");
        try {
            User usuario = userServices.getUser(nombreUsuario);
            newOffer.setUsuario(usuario);
            int idUsuario = usuario.getId();
            int idCategoria = categoryServices.getCategoryIdByName(category);
            int ofertasUsuario = userServices.getNumero_ofertas(idUsuario);
            int totalOfertas = offerServices.getTotalOfferOfUser(idUsuario);
            if (totalOfertas < ofertasUsuario) {
                offerServices.insertarOferta(newOffer, idCategoria, idUsuario);
                offers.clear();
                loadOffers();
                restartInsert();
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Oferta registrada", "La oferta ha sido registrada");
			    PrimeFaces.current().dialog().showMessageDynamic(message);
            }
        } catch (ExcepcionesSolidaridad e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "La oferta no se ha podido registrar");
			PrimeFaces.current().dialog().showMessageDynamic(message);
        }
    }

    public void updateOffer(){
        try {
            offerServices.actualizarOferta(updateId, updateStatus);
            offers.clear();
            loadOffers();
            restartUpdate();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Oferta actualizada", "La oferta ha sido actualizada");
			PrimeFaces.current().dialog().showMessageDynamic(message);
        } catch (ExcepcionesSolidaridad e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "La oferta no se ha podido actualizar");
			PrimeFaces.current().dialog().showMessageDynamic(message);
        }
    }
    
    private void createPieModel() {
        pieModel = new PieChartModel();

        int[] numerosCategorias = new int[categorias.size()];

        for (Offer offer : offers) {
            for (int i = 0; i < categorias.size(); i++) {
                if (offer.getCategory().getName().equals(categorias.get(i).getName())) {
                    numerosCategorias[i] += 1;
                }
            }
        }

        for (int i = 0; i < categorias.size(); i++) {
            pieModel.set(categorias.get(i).getName(), numerosCategorias[i]);
        }

        pieModel.setTitle("Ofertas");
        pieModel.setLegendPosition("w");
        pieModel.setShadow(false);
    }

    public List<Offer> exportOffers(){
        loadOffers();
        return offers;
    }

    public PieChartModel exportPieChart(){
        return pieModel;
    }

    private void restartInsert(){
        name = "";
        category = "";
        description = "";
        status = "";
    }

    private void restartUpdate(){
        updateId = 0;
        updateStatus = "";
    }

}
