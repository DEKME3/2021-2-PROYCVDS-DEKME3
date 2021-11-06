package edu.eci.cvds.Persistence;

import edu.eci.cvds.entities.Need;
import edu.eci.cvds.exeptions.excepciones;

public interface NeedDao {
    public void save(Need need) throws excepciones;
    public Need load(String name) throws excepciones;
}
