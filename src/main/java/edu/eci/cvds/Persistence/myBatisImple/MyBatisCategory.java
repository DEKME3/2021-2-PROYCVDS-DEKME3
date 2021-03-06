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
            if (!(category.getName().equals("") || category.getDescription().equals("") || category.getStatus().equals(""))) {
                categoryMapper.InsertCategory(category);
            } else {
                throw new ExcepcionesSolidaridad("No se logro insertar la nueva categoria.");
            }
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
            if (!(id == 0 || name.equals("") || description.equals("") || status.equals(""))) {
                categoryMapper.ActualizarCategory(id, name, description, status);
            } else {
                throw new ExcepcionesSolidaridad("No se pudo actualizar la categoria");
            }
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

    @Override
    public void deleteCategory(String name) throws ExcepcionesSolidaridad{
        try {
            if (!name.equals("")) {
                categoryMapper.deleteCategory(name); 
            } else {
                throw new ExcepcionesSolidaridad("No se pudo obtener las categorias");
            }
        } catch (Exception e) {
            throw new ExcepcionesSolidaridad("No se pudo obtener las categorias", e);
        }
        
    }

    @Override
    public int validarCategory(String name) throws ExcepcionesSolidaridad {
        return categoryMapper.validarCategory(name);
    }

    
}
