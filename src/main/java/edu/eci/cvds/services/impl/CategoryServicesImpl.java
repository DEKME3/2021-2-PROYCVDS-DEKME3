package edu.eci.cvds.services.impl;

import java.util.ArrayList;

import com.google.inject.Inject;

import edu.eci.cvds.Persistence.CategoryDao;
import edu.eci.cvds.entities.Category;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;
import edu.eci.cvds.services.CategoryServices;

public class CategoryServicesImpl implements CategoryServices{

    @Inject
    private CategoryDao categoryDao;

    @Override
    public void InsertCategory(Category category) throws ExcepcionesSolidaridad {
        categoryDao.InsertCategory(category);
    }

    @Override
    public Category getCategory(String name) throws ExcepcionesSolidaridad {
        return categoryDao.getCategory(name);
    }

    @Override
    public ArrayList<Category> getCategories() throws ExcepcionesSolidaridad {
        return categoryDao.getCategories();
    }

    @Override
    public void ActualizarCategory(int id, String name, String description, String status)
            throws ExcepcionesSolidaridad {
        categoryDao.ActualizarCategory(id, name, description, status);
        
    }

    @Override
    public int getCategoryIdByName(String name) throws ExcepcionesSolidaridad {
        return categoryDao.getCategoryIdByName(name);
    }
    
}
