package edu.eci.cvds.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.User;

public interface UserMapper {

    public void InsertUser(@Param("user") User user);
    public User getUser(@Param("name") String name);
}
