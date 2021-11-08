package edu.eci.cvds.Persistence;

import edu.eci.cvds.entities.UserType;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public interface UserTypeDao {
	
	public UserType getUserType(int id) throws ExcepcionesSolidaridad;
}
