package edu.eci.cvds.services;

import edu.eci.cvds.entities.User;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public interface UserServices {
    
    public User getUser(String name) throws ExcepcionesSolidaridad; 
    public boolean validateLogin(String name, String password);
    public int getNumero_ofertas(int id) throws ExcepcionesSolidaridad;
}
