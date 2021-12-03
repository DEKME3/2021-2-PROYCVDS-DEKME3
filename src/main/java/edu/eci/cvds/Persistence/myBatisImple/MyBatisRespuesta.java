package edu.eci.cvds.Persistence.myBatisImple;

import java.util.ArrayList;

import com.google.inject.Inject;

import edu.eci.cvds.Persistence.RespuestaDao;
import edu.eci.cvds.dao.mybatis.mappers.RespuestaMapper;
import edu.eci.cvds.entities.Respuesta;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public class MyBatisRespuesta implements RespuestaDao{

    @Inject
    private RespuestaMapper respuestaMapper;

    @Override
    public void InsertResponseOffer(Respuesta respuesta) throws ExcepcionesSolidaridad {
        if (!(respuesta.getName().equals("") || respuesta.getComments().equals("") || respuesta.getOffer() == null)) {
            respuestaMapper.InsertResponseOffer(respuesta);
        }
        else{
            throw new ExcepcionesSolidaridad("No se logro crear la nueva respuesta");
        }
    }

    @Override
    public void InsertResponseNeed(Respuesta respuesta) throws ExcepcionesSolidaridad {
        if (!(respuesta.getName().equals("") || respuesta.getComments().equals("") || respuesta.getNeed() == null)) {
            respuestaMapper.InsertResponseNeed(respuesta);
        }
        else{
            throw new ExcepcionesSolidaridad("No se logro crear la nueva respuesta");
        }
    }

    @Override
    public ArrayList<Respuesta> getResponsesOffer() throws ExcepcionesSolidaridad {
        return respuestaMapper.getResponsesOffer();
    }

    @Override
    public ArrayList<Respuesta> getResponsesNeed() throws ExcepcionesSolidaridad {
        return respuestaMapper.getResponsesNeed();
    }
    
}
