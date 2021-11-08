package edu.eci.cvds.Persistence;

import edu.eci.cvds.entities.Need;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public interface NeedDao {
    public void save(Need need) throws ExcepcionesSolidaridad;
    public Need load(String name) throws ExcepcionesSolidaridad;
}
