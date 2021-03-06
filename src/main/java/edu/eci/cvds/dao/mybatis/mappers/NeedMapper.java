package edu.eci.cvds.dao.mybatis.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.Need;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;


public interface NeedMapper {

    public void insertNeed(@Param("need") Need need, @Param("categoryId") int categoryId, @Param("userId") int userId);
    public int getTotalNeedsOfUser(@Param("userId") int id);
    public void ActualizarNeed(@Param("id") int id, @Param("status") String status);
    public ArrayList<Need> getNeedsResult(@Param("usuario") int usuario);
    public int getIdUserByNeed(@Param("id") int id);
    public ArrayList<Need> getNeeds();
    public Need getNeed(@Param("id") int id);
    public int countCategories(@Param("category") int category);
    public ArrayList<Need> getNeedsReporte() throws ExcepcionesSolidaridad;
}

