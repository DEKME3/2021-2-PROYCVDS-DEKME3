package edu.eci.cvds.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Category;

public interface UserMapper {

    public void InsertCategory(@Param("category") Category category);
    public User getCategory(@Param("name") String name);
}
