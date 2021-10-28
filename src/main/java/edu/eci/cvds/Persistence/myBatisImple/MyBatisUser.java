package edu.eci.cvds.Persistence.myBatisImple;

import com.google.inject.Inject;

import edu.eci.cvds.Persistence.UserDao;
import edu.eci.cvds.dao.mybatis.mappers.UserMapper;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.exeptions.excepciones;

public class MyBatisUser implements UserDao{

    @Inject
    private UserMapper userMapper;
	
	@Override
	public void InsertUser(User user) throws excepciones {
        try {
            userMapper.InsertUser(new User(user.getName(), user.getPassword(), user.getEmail(), user.getStatus(), user.getUserType()));
        } catch (Exception e) {
            throw new excepciones("No se logro crear el nuevo Usuario.", e);
        }
		
	}

	@Override
	public User getUser(int id) throws excepciones {
        try {
            userMapper.getUser(id);
        } catch (Exception e) {
            throw new excepciones("No se logro obtener un Usuario.", e);
        }
		return null;
	}

}
