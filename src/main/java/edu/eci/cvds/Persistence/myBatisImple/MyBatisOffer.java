package edu.eci.cvds.Persistence.myBatisImple;


import java.util.ArrayList;

import com.google.inject.Inject;
import edu.eci.cvds.Persistence.OfferDao;
import edu.eci.cvds.dao.mybatis.mappers.OfferMapper;
import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public class MyBatisOffer implements OfferDao {

    @Inject
    private OfferMapper offerMapper;

    @Override
    public void insertarOferta(Offer offer, int category, int userId) throws ExcepcionesSolidaridad {
        try {
            if (!(offer.getName().equals("") || category == 0 || userId == 0 || offer.getDescription().equals("") || offer.getStatus().equals(""))) {
                offerMapper.InsertOffer(offer, category, userId);
            } else {
                throw new ExcepcionesSolidaridad("No se logro crear la nueva oferta");
            }
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se logro crear la nueva oferta", e);
        }
    }

    @Override
    public Offer getOferta(int id) throws ExcepcionesSolidaridad {
        try {
            return offerMapper.getOffer(id);
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se logro obtener la oferta.", e);
        }
    }

    @Override
    public void actualizarOferta(int id, String status) throws ExcepcionesSolidaridad {
        try {
            if (!(id == 0 || status.equals(""))) {
                offerMapper.ActualizarOffer(id, status); 
            } else {
                throw new ExcepcionesSolidaridad("No se logro actualizar la oferta.");
            }
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se logro actualizar la oferta.", e);
        }
    }

    @Override
    public ArrayList<Offer> getOfertas() {
        return offerMapper.getOffers();
    }

    @Override
    public int getOfferIdByName(String name) throws ExcepcionesSolidaridad {
        return offerMapper.getOfferIdByName(name);
    }

    @Override
    public int getTotalOfferOfUser(int id) throws ExcepcionesSolidaridad {
        return offerMapper.getTotalOfferOfUser(id);
    }

    @Override
    public int countCategories(int category) throws ExcepcionesSolidaridad {
        return offerMapper.countCategories(category);
    }

    @Override
    public int getIdUserByOffer(int id) throws ExcepcionesSolidaridad {
        try {
            return offerMapper.getIdUserByOffer(id);
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se logro obtener el id del usuario dado el id de la oferta: : "+ id, e);
        }
    }

}