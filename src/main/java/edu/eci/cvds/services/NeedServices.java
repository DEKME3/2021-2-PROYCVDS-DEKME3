package edu.eci.cvds.services;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Need;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;
public interface NeedServices {
    public void insertNeed( Need need,  int categoryId,  int userId) throws ExcepcionesSolidaridad;
    public int getTotalNeedsOfUser(int id) throws ExcepcionesSolidaridad;
    public void ActualizarNeed(int id, String status) throws ExcepcionesSolidaridad;
    public Need getNeedsResult(String usuario) throws ExcepcionesSolidaridad;
    public int getIdUserByNeed(int id) throws ExcepcionesSolidaridad;
}
