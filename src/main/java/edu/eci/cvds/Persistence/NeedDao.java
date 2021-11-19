package edu.eci.cvds.Persistence;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Need;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public interface NeedDao {
    public void insertNeed(@Param("need") Need need, @Param("categoryId") int categoryId, @Param("userId") int userId) throws ExcepcionesSolidaridad;
    public int getTotalNeedsOfUser(@Param("userId") int id) throws ExcepcionesSolidaridad;
    public void ActualizarNeed(@Param("id") int id, @Param("status") String status) throws ExcepcionesSolidaridad;
    public ArrayList<Need> getNeedsResult(@Param("usuario") int usuario) throws ExcepcionesSolidaridad;
    public int getIdUserByNeed(@Param("id") int id) throws ExcepcionesSolidaridad;
    public ArrayList<Need> getNeeds() throws ExcepcionesSolidaridad;
    public Need getNeed(@Param("id") int id) throws ExcepcionesSolidaridad;
}
