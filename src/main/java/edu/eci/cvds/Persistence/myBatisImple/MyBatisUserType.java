package edu.eci.cvds.Persistence.myBatisImple;

import com.google.inject.Inject;

import edu.eci.cvds.Persistence.UserTypeDao;
import edu.eci.cvds.dao.mybatis.mappers.UserTypeMapper;
import edu.eci.cvds.entities.UserType;
import edu.eci.cvds.exeptions.excepciones;

public class MyBatisUserType implements UserTypeDao{
	
    @Inject
    private UserTypeMapper userTypeMapper;
	
	@Override
	public UserType getUserType(int id) throws excepciones {
        try {
        	userTypeMapper.getUserType(id);
        } catch (Exception e) {
            throw new excepciones("No se logro obtener el UserType.", e);
        }
		return null;
	}

}
