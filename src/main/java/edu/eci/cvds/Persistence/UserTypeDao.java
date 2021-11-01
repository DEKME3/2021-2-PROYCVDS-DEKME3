package edu.eci.cvds.Persistence;

import edu.eci.cvds.entities.UserType;
import edu.eci.cvds.exeptions.excepciones;

public interface UserTypeDao {
	
	public UserType getUserType(int id) throws excepciones;
}
