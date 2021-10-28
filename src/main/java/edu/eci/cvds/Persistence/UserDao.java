package edu.eci.cvds.Persistence;

import edu.eci.cvds.entities.*;
import edu.eci.cvds.exeptions.*;

public interface UserDao {
	
    public void InsertUser(User user) throws excepciones;
    public User getUser(String name) throws excepciones;
}
