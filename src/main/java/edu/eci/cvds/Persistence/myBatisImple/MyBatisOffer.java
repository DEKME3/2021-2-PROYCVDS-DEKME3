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
            offerMapper.InsertOffer(new Offer(offer.getName(), offer.getDescription(), offer.getCreationDate(), offer.getStatus(), offer.getModificationDate()) , category, userId);
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se logro crear la nueva oferta", e);
        }
    }

    @Override
    public Offer getOferta(String name) throws ExcepcionesSolidaridad {
        try {
            return offerMapper.getOffer(name);
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se logro obtener la oferta.", e);
        }
    }

    @Override
    public void actualizarOferta(int id, String status) throws ExcepcionesSolidaridad {
        try {
            offerMapper.ActualizarOffer(id, status);
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se logro actualizar la oferta.", e);
        }
    }

    @Override
    public ArrayList<Offer> getOfertas() {
        return offerMapper.getOffers();
    }

}