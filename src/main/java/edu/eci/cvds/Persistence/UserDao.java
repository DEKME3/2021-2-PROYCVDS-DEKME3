package edu.eci.cvds.Persistence;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.*;
import edu.eci.cvds.exeptions.*;

public interface UserDao {
	
    public void InsertUser(User user) throws ExcepcionesSolidaridad;
    public User getUser(String name) throws ExcepcionesSolidaridad;
    public int getNumero_ofertas(int id) throws ExcepcionesSolidaridad;
    public int getNumero_necesidades(int id) throws ExcepcionesSolidaridad;
    public int getIdUserByName(String name) throws ExcepcionesSolidaridad;
    public int getIdUserTypeByIdUser(int id) throws ExcepcionesSolidaridad;
}
