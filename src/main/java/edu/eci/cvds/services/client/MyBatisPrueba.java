package edu.eci.cvds.services.client;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;

import edu.eci.cvds.dao.mybatis.mappers.*;
import edu.eci.cvds.entities.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
        //CategoryMapper categoryMapper = sqlss.getMapper(CategoryMapper.class);
        NeedMapper needmappers = sqlss.getMapper(NeedMapper.class);
        //fferMapper offermappers = sqlss.getMapper(OfferMapper.class);


        // Imprimir usertype OK
        //System.out.println(userTypeMapper.getUserType(2).toString());

        // Imprimir user OK
        //System.out.println(userMapper.getUser(1).toString());

        // Insertar user OK
        //UserType ut = userTypeMapper.getUserType(1);
        //userMapper.InsertUser(new User("Kristhian", "666", "kristhian@gmail.com", true, ut));

        // Insertar category OK
        //categoryMapper.InsertCategory(new Category("Prueba 3", "descripcion3", new Date(), "status 3", new Date()));
        
        //Insertar need OK
        needmappers.insertNeed(new Need("Cuadernitoxd2", "Prueba2", new Date(), "Creado", new Date(), "Alta"), 3 , 2);


        //Insertar Offer ok
        //offermappers.InsertOffer(new Offer("Cuadernitoprueba", "Prueba1", new Date(), "Creado", new Date()), 3);
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

    public static void updateCategoria(int id, String newName, String newDescription, String newStatus){
        SqlSessionFactory sessionfact = getSqlSessionFactory();
        SqlSession sqlss = sessionfact.openSession();
        CategoryMapper categoryMapper = sqlss.getMapper(CategoryMapper.class);
        categoryMapper.ActualizarCategory(id, newName, newDescription, newStatus);
        sqlss.commit();   
        sqlss.close();
    }
    
     public static void insertarNecesidad(Need newNeed){
         SqlSessionFactory sessionfact = getSqlSessionFactory();
         SqlSession sqlss = sessionfact.openSession();
        NeedMapper needmapper = sqlss.getMapper(NeedMapper.class);
        needmapper.insertNeed(newNeed, 3, 2);
        sqlss.commit();   
        sqlss.close();
     }
}