package edu.eci.cvds.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.Respuesta;

public interface RespuestaMappers{

    public void InsertRespuesta(@Param("respuesta") Respuesta respuesta);
    public Category getCategory(@Param("name") String name);

}
