package edu.eci.cvds.Persistence;

import java.util.ArrayList;

import edu.eci.cvds.entities.Respuesta;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public interface RespuestaDao {

    public void InsertResponseOffer(Respuesta respuesta) throws ExcepcionesSolidaridad;
    public void InsertResponseNeed(Respuesta respuesta) throws ExcepcionesSolidaridad;
    public ArrayList<Respuesta> getResponsesOffer() throws ExcepcionesSolidaridad;
    public ArrayList<Respuesta> getResponsesNeed() throws ExcepcionesSolidaridad;
}
