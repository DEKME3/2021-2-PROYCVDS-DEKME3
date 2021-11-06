package edu.eci.cvds.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Need;

public interface needMapper {
    public void InsertCategory(@Param("need") Need need);
    public Need getCategory(@Param("name") String name);
    //public void ActualizarCategory(@Param("id") int id,@Param("name") String name, @Param("description") String description, @Param("status") String status);
}
