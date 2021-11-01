package edu.eci.cvds.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.UserType;

public interface UserTypeMapper {


    public UserType getUserType(@Param("id") int id);

    
}