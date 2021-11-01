package edu.eci.cvds.services;

import edu.eci.cvds.entities.User;

public interface UserServices {
    
    public User getUser(String name); 
    public boolean validateLogin(String name, String password);
}
