package edu.eci.cvds.services.impl;

import java.util.ArrayList;

import com.google.inject.Inject;

import edu.eci.cvds.Persistence.RespuestaDao;
import edu.eci.cvds.entities.Respuesta;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;
import edu.eci.cvds.services.RespuestaServices;

public class RespuestaServicesImpl implements RespuestaServices{

    @Inject
    private RespuestaDao respuestaDao;

    @Override
    public void InsertResponseOffer(Respuesta respuesta) throws ExcepcionesSolidaridad {
        respuestaDao.InsertResponseOffer(respuesta);
    }

    @Override
    public void InsertResponseNeed(Respuesta respuesta) throws ExcepcionesSolidaridad {
        respuestaDao.InsertResponseNeed(respuesta);
    }

    @Override
    public ArrayList<Respuesta> getResponsesOffer() throws ExcepcionesSolidaridad {
        return respuestaDao.getResponsesOffer();
    }

    @Override
    public ArrayList<Respuesta> getResponsesNeed() throws ExcepcionesSolidaridad {
        return respuestaDao.getResponsesNeed();
    }
    
}
