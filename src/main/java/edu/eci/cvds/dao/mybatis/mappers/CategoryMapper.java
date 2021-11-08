package edu.eci.cvds.dao.mybatis.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.Category;

public interface CategoryMapper {

    public void InsertCategory(@Param("category") Category category);
    public Category getCategory(@Param("nombre") String name);
    public void ActualizarCategory(@Param("id") int id,@Param("name") String name, @Param("description") String description, @Param("status") String status);
    public ArrayList<Category> getCategories();

}