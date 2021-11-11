package edu.eci.cvds.Persistence;

import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public interface OfferDao {
    public void save(Offer offer) throws ExcepcionesSolidaridad;
    public Offer load(String name) throws ExcepcionesSolidaridad;
}
