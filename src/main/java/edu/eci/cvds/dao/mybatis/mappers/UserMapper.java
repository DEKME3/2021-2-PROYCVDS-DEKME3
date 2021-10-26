package edu.eci.cvds.dao.mybatis.mappers;

import java.util.List;

import edu.eci.cvds.entities.User;

public interface UserMapper {

    public void InsertarUsuario (User usuario);
    public List<User> consultarUsuario();
    
}
