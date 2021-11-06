package edu.eci.cvds.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.Need;


public interface NeedMapper {
    public void insertNeed(@Param("need") Need need);
    public Need getNeed(@Param("name") String name);
    //public void ActualizarNeed(@Param("id") int id,@Param("name") String name, @Param("description") String description, @Param("status") String status);
}
