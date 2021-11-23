package edu.eci.cvds.services;

import edu.eci.cvds.entities.Respuesta;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public interface RespuestaServices {
    
    public void InsertResponseOffer(Respuesta respuesta) throws ExcepcionesSolidaridad;
    public void InsertResponseNeed(Respuesta respuesta) throws ExcepcionesSolidaridad;

}