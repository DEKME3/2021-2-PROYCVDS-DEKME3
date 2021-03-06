package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import edu.eci.cvds.Persistence.CategoryDao;
import edu.eci.cvds.Persistence.OfferDao;
import edu.eci.cvds.Persistence.RespuestaDao;
import edu.eci.cvds.Persistence.UserDao;
import edu.eci.cvds.Persistence.myBatisImple.MyBatisCategory;
import edu.eci.cvds.Persistence.myBatisImple.MyBatisOffer;
import edu.eci.cvds.Persistence.myBatisImple.MyBatisRespuesta;
import edu.eci.cvds.Persistence.myBatisImple.MyBatisUser;
import edu.eci.cvds.services.CategoryServices;
import edu.eci.cvds.services.OfferServices;
import edu.eci.cvds.services.RespuestaServices;
import edu.eci.cvds.services.UserServices;
import edu.eci.cvds.services.impl.CategoryServicesImpl;
import edu.eci.cvds.services.impl.OfferServicesImpl;
import edu.eci.cvds.services.impl.RespuestaServicesImpl;
import edu.eci.cvds.services.impl.UserServicesImpl;

public class GuiceContextListener implements ServletContextListener{
    
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");
                bind(UserDao.class).to(MyBatisUser.class);
                bind(UserServices.class).to(UserServicesImpl.class);
                bind(CategoryDao.class).to(MyBatisCategory.class);
                bind(CategoryServices.class).to(CategoryServicesImpl.class);
                bind(OfferDao.class).to(MyBatisOffer.class);
                bind(OfferServices.class).to(OfferServicesImpl.class);
                bind(RespuestaDao.class).to(MyBatisRespuesta.class);
                bind(RespuestaServices.class).to(RespuestaServicesImpl.class);
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }

}
