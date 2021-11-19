package edu.eci.cvds.services.impl;

import java.util.ArrayList;

import com.google.inject.Inject;

import edu.eci.cvds.Persistence.OfferDao;
import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;
import edu.eci.cvds.services.OfferServices;

public class OfferServicesImpl implements OfferServices{

    @Inject
    private OfferDao offerDao;

    @Override
    public void insertarOferta(Offer offer, int category, int userId) throws ExcepcionesSolidaridad {
        offerDao.insertarOferta(offer, category, userId);
    }

    @Override
    public Offer getOferta(int id) throws ExcepcionesSolidaridad {
        return offerDao.getOferta(id);
    }

    @Override
    public void actualizarOferta(int id, String status) throws ExcepcionesSolidaridad {
        offerDao.actualizarOferta(id, status);
    }

    @Override
    public ArrayList<Offer> getOfertas() throws ExcepcionesSolidaridad{
        return offerDao.getOfertas();
    }

    @Override
    public int getOfferIdByName(String name) throws ExcepcionesSolidaridad {
        return offerDao.getOfferIdByName(name);
    }

    @Override
    public int getTotalOfferOfUser(int id) throws ExcepcionesSolidaridad {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
