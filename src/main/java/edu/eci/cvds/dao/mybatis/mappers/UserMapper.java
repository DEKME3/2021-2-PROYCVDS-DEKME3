package edu.eci.cvds.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.User;
import edu.eci.cvds.entities.UserType;

public interface UserMapper {

    public void InsertUser(@Param("user") User user);
    public User getUser(@Param("name") String name);
}
