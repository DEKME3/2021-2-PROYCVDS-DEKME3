package edu.eci.cvds.ManageBeans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.eci.cvds.entities.Need;
import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.entities.Respuesta;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;
import edu.eci.cvds.services.NeedServices;
import edu.eci.cvds.services.OfferServices;
import edu.eci.cvds.services.RespuestaServices;
import edu.eci.cvds.services.ServicesFactory;

@SuppressWarnings("deprecation")
@SessionScoped
@ManagedBean(name = "respuestaBean")

public class respuestaBean {
    
    private String nameR;
    private String commentsR;
    private Date creationDateR;
    private int offerR;
    private int needR;
    private RespuestaServices respuestaServices = ServicesFactory.getInstance().getRespuestaServices();
    private OfferServices ofertaServices = ServicesFactory.getInstance().getOfferServices();
    private NeedServices needServices = ServicesFactory.getInstance().getNeedServices();

    public respuestaBean() {
    }

    

    public String getNameR() {
        return nameR;
    }



    public void setNameR(String nameR) {
        this.nameR = nameR;
    }



    public String getCommentsR() {
        return commentsR;
    }



    public void setCommentsR(String commentsR) {
        this.commentsR = commentsR;
    }



    public Date getCreationDateR() {
        return creationDateR;
    }



    public void setCreationDateR(Date creationDateR) {
        this.creationDateR = creationDateR;
    }



    public int getOfferR() {
        return offerR;
    }



    public void setOfferR(int offerR) {
        this.offerR = offerR;
    }



    public int getNeedR() {
        return needR;
    }



    public void setNeedR(int needR) {
        this.needR = needR;
    }


    public void insertarRespuestaOffer(){
        try {
            Offer ofertaR = ofertaServices.getOferta(offerR);
            Respuesta respuesta = new Respuesta(nameR, commentsR, new Date(), ofertaR);
            respuestaServices.InsertResponseOffer(respuesta);
        } catch (ExcepcionesSolidaridad e) {
            e.printStackTrace();
        }
    }

    public void insertarRespuestaNeed(){
        try {
            Need necesidad = needServices.getNeed(needR);
            Respuesta respuesta = new Respuesta(nameR, commentsR, new Date(), necesidad);
            respuestaServices.InsertResponseNeed(respuesta);
        } catch (ExcepcionesSolidaridad e) {
            e.printStackTrace();
        }
    }

}