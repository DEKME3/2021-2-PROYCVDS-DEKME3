package edu.eci.cvds.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Respuesta;

public interface RespuestaMapper{

    public void InsertResponseOffer(@Param("ans") Respuesta respuesta);
    public void InsertResponseNeed(@Param("ans") Respuesta respuesta);

}