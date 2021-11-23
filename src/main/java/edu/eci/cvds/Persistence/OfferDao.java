package edu.eci.cvds.Persistence;

import java.util.ArrayList;

import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public interface OfferDao {
    public void insertarOferta(Offer offer, int category, int userId) throws ExcepcionesSolidaridad;
    public Offer getOferta(int id) throws ExcepcionesSolidaridad;
    public ArrayList<Offer> getOfertas();
    public void actualizarOferta(int id, String status) throws ExcepcionesSolidaridad;
    public int getOfferIdByName(String name) throws ExcepcionesSolidaridad;
    public int getTotalOfferOfUser(int id) throws ExcepcionesSolidaridad;
    public int countCategories(int category) throws ExcepcionesSolidaridad;
}
