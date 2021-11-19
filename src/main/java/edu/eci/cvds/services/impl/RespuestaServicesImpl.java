package edu.eci.cvds.services.impl;

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
    
}
