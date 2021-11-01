package edu.eci.cvds.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Category;

public interface CategoryMapper {

    public void InsertCategory(@Param("category") Category category);
    public Category getCategory(@Param("name") String name);
}
