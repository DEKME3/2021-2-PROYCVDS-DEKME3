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
    public User getUser(String name) {
        try {
            return userDao.getUser(name);
        } catch (ExcepcionesSolidaridad e) {
            e.printStackTrace();
            return null;
        }
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
    
}
