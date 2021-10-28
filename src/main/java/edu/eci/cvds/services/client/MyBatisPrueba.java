package edu.eci.cvds.services.client;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.cvds.entities.UserType;
import edu.eci.cvds.dao.mybatis.mappers.UserMapper;
import edu.eci.cvds.dao.mybatis.mappers.UserTypeMapper;
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
        UserMapper userMapper = sqlss.getMapper(UserMapper.class);
        UserTypeMapper userTypeMapper = sqlss.getMapper(UserTypeMapper.class);

        // Imprimir usertype OK
        //System.out.println(userTypeMapper.getUserType(2).toString());

        // Imprimir user OK
        System.out.println(userMapper.getUser(1).toString());

        // Insertar user OK
        //UserType ut = userTypeMapper.getUserType(1);
        //userMapper.InsertarUsuario(new User("Kristhian", "666", "kristhian@gmail.com", true, ut));
        
        sqlss.commit();
        
        
        sqlss.close();

        
        
    }
}
