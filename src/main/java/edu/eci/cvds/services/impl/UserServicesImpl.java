package edu.eci.cvds.services.impl;

import com.google.inject.Inject;

import edu.eci.cvds.Persistence.UserDao;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;
import edu.eci.cvds.services.UserServices;

public class UserServicesImpl implements UserServices{

    @Inject
    private UserDao userDao;

    @Override
    public User getUser(String name) throws ExcepcionesSolidaridad{
        return userDao.getUser(name);
    }

    @Override
    public boolean validateLogin(String name, String password) {
        try {
            User user = userDao.getUser(name);
            if (user != null) {
                return true;
            } 
            else{
                return false;
            }
        } catch (ExcepcionesSolidaridad e) {
            e.printStackTrace();
            return false;
        } 
    }

    @Override
    public int getNumero_ofertas(int id) throws ExcepcionesSolidaridad {
        return userDao.getNumero_ofertas(id);
    }

	@Override
	public int getNumero_necesidades(int id) throws ExcepcionesSolidaridad {
		return userDao.getNumero_necesidades(id);
	}

	@Override
	public int getIdUserByName(String name) throws ExcepcionesSolidaridad {
		return userDao.getIdUserByName(name);
	}

	@Override
	public int getIdUserTypeByIdUser(int id) throws ExcepcionesSolidaridad {
		return userDao.getIdUserTypeByIdUser(id);
	}

	@Override
	public void ActualizarNeedUserByName(int idName, int necesidades) throws ExcepcionesSolidaridad {
		userDao.ActualizarNeedUserByName(idName, necesidades);	
		
	}
    
}
