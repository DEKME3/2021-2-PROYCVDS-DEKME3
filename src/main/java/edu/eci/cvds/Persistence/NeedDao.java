package edu.eci.cvds.Persistence;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Need;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public interface NeedDao {
    public void insertNeed(@Param("need") Need need, @Param("categoryId") int categoryId, @Param("userId") int userId) throws ExcepcionesSolidaridad;
    public int getTotalNeedsOfUser(@Param("userId") int id) throws ExcepcionesSolidaridad;
    public void ActualizarNeed(@Param("id") int id, @Param("status") String status) throws ExcepcionesSolidaridad;
    public Need getNeedsResult(@Param("usuario") String usuario) throws ExcepcionesSolidaridad;
    public int getIdUserByNeed(@Param("id") int id) throws ExcepcionesSolidaridad;
}
