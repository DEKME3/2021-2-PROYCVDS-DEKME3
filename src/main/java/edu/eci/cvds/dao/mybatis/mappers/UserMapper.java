package edu.eci.cvds.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.User;

public interface UserMapper {

    public void InsertarUsuario (@Param("user") User user);
    public List<User> consultarUsuario();
    
}
