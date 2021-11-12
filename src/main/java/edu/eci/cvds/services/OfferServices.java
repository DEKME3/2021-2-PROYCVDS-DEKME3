package edu.eci.cvds.services;

import java.util.ArrayList;

import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public interface OfferServices {
    public void insertarOferta(Offer offer, int category, int userId) throws ExcepcionesSolidaridad;
    public Offer getOferta(String name) throws ExcepcionesSolidaridad;
    public ArrayList<Offer> getOfertas() throws ExcepcionesSolidaridad;
    public void actualizarOferta(int id, String status) throws ExcepcionesSolidaridad;
}