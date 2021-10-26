package edu.eci.cvds.dao.mybatis.mappers;

import java.util.List;

import edu.eci.cvds.entities.User;
import edu.eci.cvds.entities.UserType;

public interface UserTypeMapper {


    public List<UserType> consultarUserType();

    
}