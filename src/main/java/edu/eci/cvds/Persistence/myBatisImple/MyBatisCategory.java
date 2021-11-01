package edu.eci.cvds.Persistence.myBatisImple;

import com.google.inject.Inject;

import edu.eci.cvds.Persistence.CategoryDao;
import edu.eci.cvds.dao.mybatis.mappers.CategoryMapper;
import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.exeptions.excepciones;

public class MyBatisCategory implements CategoryDao{
    
    @Inject
    private CategoryMapper categoryMapper;

    @Override
    public void save(Category category) throws excepciones {
        try {
            categoryMapper.InsertCategory(new Category(category.getName(), category.getDescription(), category.getCreationDate(), category.getStatus()));
        } catch (Exception e) {
            throw new excepciones("No se logro crear la nueva categoria", e);
        }
        
    }

    @Override
    public Category load(String name) throws excepciones {
        try {
            return categoryMapper.getCategory(name);
        } catch (Exception e) {
            throw new excepciones("No se logro obtener un Usuario.", e);
        }
    }
}
