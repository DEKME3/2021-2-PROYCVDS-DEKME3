package edu.eci.cvds.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.Persistence.UserDao;
import edu.eci.cvds.Persistence.myBatisImple.MyBatisUser;
import edu.eci.cvds.services.UserServices;
import edu.eci.cvds.services.impl.UserServicesImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

public class GuiceContextListener {

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
                // TODO Add service class associated to Stub implementation
                bind(UserDao.class).to(MyBatisUser.class);
                bind(UserServices.class).to(UserServicesImpl.class);
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }

}