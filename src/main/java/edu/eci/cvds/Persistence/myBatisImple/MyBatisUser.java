package edu.eci.cvds.Persistence.myBatisImple;

import com.google.inject.Inject;

import edu.eci.cvds.Persistence.UserDao;
import edu.eci.cvds.dao.mybatis.mappers.UserMapper;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public class MyBatisUser implements UserDao{

    @Inject
    private UserMapper userMapper;
	
	@Override
	public void InsertUser(User user) throws ExcepcionesSolidaridad {
        try {
            userMapper.InsertUser(new User(user.getName(), user.getPassword(), user.getEmail(), user.getStatus(), user.getUserType() , user.getNumero_necesidades(), user.getNumero_ofertas()));
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se logro crear el nuevo Usuario.", e);
        }
		
	}

	@Override
	public User getUser(String name) throws ExcepcionesSolidaridad {
        try {
            return userMapper.getUser(name);
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se logro obtener un Usuario.", e);
        }
	}

    @Override
    public int getNumero_ofertas(int id) throws ExcepcionesSolidaridad {
        return userMapper.getNumero_ofertas(id);
    }

	@Override
	public int getNumero_necesidades(int id) throws ExcepcionesSolidaridad {
		// TODO Auto-generated method stub
		return userMapper.getNumero_necesidades(id);
	}

	@Override
	public int getIdUserByName(String name) throws ExcepcionesSolidaridad {
		return userMapper.getUserIdByName(name);
	}

	@Override
	public int getIdUserTypeByIdUser(int id) throws ExcepcionesSolidaridad {
		return userMapper.getUserType(id);
	}

	@Override
	public void ActualizarNeedUserByName(int  idName, int necesidades) throws ExcepcionesSolidaridad {
		try {
			userMapper.ActualizarNeedUserByName(idName, necesidades);
	     }catch (Exception e) {
	    	 throw new ExcepcionesSolidaridad("No se Actualziar el Número de necesidades del usuario con id:"+idName, e);
	     }
	}

}
