package edu.eci.cvds.Persistence;
 
import java.util.ArrayList;

import edu.eci.cvds.entities.*;
import edu.eci.cvds.exeptions.*;
 
public interface CategoryDao {
    
    public void InsertCategory(Category category) throws ExcepcionesSolidaridad;
    public Category getCategory(String name) throws ExcepcionesSolidaridad;
    public ArrayList<Category> getCategories() throws ExcepcionesSolidaridad;
    public void ActualizarCategory(int id, String name, String description, String status) throws ExcepcionesSolidaridad;
    public int getCategoryIdByName(String name) throws ExcepcionesSolidaridad;
    
}