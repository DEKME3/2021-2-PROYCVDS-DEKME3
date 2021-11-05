package edu.eci.cvds.services.client;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.cvds.entities.UserType;
import edu.eci.cvds.dao.mybatis.mappers.CategoryMapper;
import edu.eci.cvds.dao.mybatis.mappers.UserMapper;
import edu.eci.cvds.dao.mybatis.mappers.UserTypeMapper;
import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.User;

public class MyBatisPrueba {
    
    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();
        SqlSession sqlss = sessionfact.openSession();
        
        // Crear el mapper y usarlo: 
        // UserMapper userMapper = sqlss.getMapper(UserMapper.class);
        // UserTypeMapper userTypeMapper = sqlss.getMapper(UserTypeMapper.class);
        CategoryMapper categoryMapper = sqlss.getMapper(CategoryMapper.class);

        // Imprimir usertype OK
        //System.out.println(userTypeMapper.getUserType(2).toString());

        // Imprimir user OK
        //System.out.println(userMapper.getUser(1).toString());

        // Insertar user OK
        // UserType ut = userTypeMapper.getUserType(1);
        // userMapper.InsertUser(new User("Kristhian", "666", "kristhian@gmail.com", true, ut));

        // Insertar category OK
        // categoryMapper.InsertCategory(new Category("Categoriaaa", "descripcion2", new Date(), "status", new Date()));
        
        categoryMapper.ActualizarCategory(1, "Prueba2", "Prueba actualizacion2", "Abierto");

        sqlss.commit();
        
        
        sqlss.close();
    }

    public static UserType validarUserType(String name){
        SqlSessionFactory sessionfact = getSqlSessionFactory();
        SqlSession sqlss = sessionfact.openSession();
        UserMapper userMapper = sqlss.getMapper(UserMapper.class);
        return userMapper.getUser(name).getUserType();
    }

    public static void insertarCategoria(Category newCategory){
        SqlSessionFactory sessionfact = getSqlSessionFactory();
        SqlSession sqlss = sessionfact.openSession();
        CategoryMapper categoryMapper = sqlss.getMapper(CategoryMapper.class);
        categoryMapper.InsertCategory(newCategory);
        sqlss.commit();   
        sqlss.close();
    }
}
