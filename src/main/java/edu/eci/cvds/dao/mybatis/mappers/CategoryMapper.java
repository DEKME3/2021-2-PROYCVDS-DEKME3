package edu.eci.cvds.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.Category;

public interface CategoryMapper {

    public void InsertCategory(@Param("category") Category category);
    public Category getCategory(@Param("id") int id);
    public void ActualizarCategory(@Param("id") int id,@Param("name") String name, @Param("description") String description, @Param("status") String status);
}
