package edu.eci.cvds.Persistence;

import edu.eci.cvds.entities.*;
import edu.eci.cvds.exeptions.*;

public interface UserDao {
	
    public void InsertUser(User user) throws ExcepcionesSolidaridad;
    public User getUser(String name) throws ExcepcionesSolidaridad;
    public int getNumero_ofertas(int id) throws ExcepcionesSolidaridad;
}
