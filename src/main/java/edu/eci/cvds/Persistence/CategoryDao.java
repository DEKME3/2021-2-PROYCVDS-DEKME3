package edu.eci.cvds.Persistence;
 
import edu.eci.cvds.entities.*;
import edu.eci.cvds.exeptions.*;
 
public interface CategoryDao {
    
    public void save(Category category) throws excepciones;
    public Category load(String name) throws excepciones;
}