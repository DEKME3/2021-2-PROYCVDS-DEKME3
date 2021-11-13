package edu.eci.cvds.Persistence.myBatisImple;

import java.util.ArrayList;

import com.google.inject.Inject;

import edu.eci.cvds.Persistence.CategoryDao;
import edu.eci.cvds.dao.mybatis.mappers.CategoryMapper;
import edu.eci.cvds.entities.Category;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public class MyBatisCategory implements CategoryDao{
    
    @Inject
    private CategoryMapper categoryMapper;

    @Override
    public void InsertCategory(Category category) throws ExcepcionesSolidaridad {
        try {
            categoryMapper.InsertCategory(category);
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se logro insertar la nueva categoria.", e);
        }
        
    }

    @Override
    public Category getCategory(String name) throws ExcepcionesSolidaridad {
        try {
            return categoryMapper.getCategory(name);
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se pudo obtener la categoria", e);
        }
    }

    @Override
    public void ActualizarCategory(int id, String name, String description, String status)
            throws ExcepcionesSolidaridad {
        try {
            categoryMapper.ActualizarCategory(id, name, description, status);
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se pudo actualizar la categoria", e);
        }
        
    }

    @Override
    public ArrayList<Category> getCategories() throws ExcepcionesSolidaridad {
        try {
            return categoryMapper.getCategories();
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se pudo obtener las categorias", e);
        }
    }

    @Override
    public int getCategoryIdByName(String name) throws ExcepcionesSolidaridad {
        return categoryMapper.getCategoryIdByName(name);    
    }

    
}
