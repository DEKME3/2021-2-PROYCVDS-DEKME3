package edu.eci.cvds.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.Need;


public interface NeedMapper {

    public void insertNeed(@Param("need") Need need, @Param("categoryId") int categoryId, @Param("userId") int userId);
    public Need getNeed(@Param("name") String name);
    public int getTotalNeedsOfUser(@Param("userId") int id);
    public void ActualizarNeed(@Param("id") int id, @Param("status") String status, @Param("user") int usuario);
    public Need getNeedsResult(@Param("usuario") String usuario);
}

