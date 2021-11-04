package edu.eci.cvds.services;

import com.google.inject.Injector;
import org.mybatis.guice.XMLMyBatisModule;
import edu.eci.cvds.Persistence.UserDao;
import edu.eci.cvds.Persistence.UserTypeDao;
import edu.eci.cvds.Persistence.myBatisImple.MyBatisUser;
import edu.eci.cvds.Persistence.myBatisImple.MyBatisUserType;
import edu.eci.cvds.authenticator.SessionLogger;
import edu.eci.cvds.authenticator.ShiroSession;
import edu.eci.cvds.services.impl.UserServicesImpl;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;


public class ServicesFactory {

   private static final ServicesFactory instance = new ServicesFactory();

   private static Optional<Injector> optInjector = Optional.empty();

   private Injector myBatisInjector(String env, String pathResource) {
       return createInjector(new XMLMyBatisModule() {
           @Override
           protected void initialize() {
               setEnvironmentId(env);
               setClassPathResource(pathResource);
               bind(UserDao.class).to(MyBatisUser.class);
               bind(UserTypeDao.class).to(MyBatisUserType.class);
               bind(UserServices.class).to(UserServicesImpl.class);
               bind(SessionLogger.class).to(ShiroSession.class);
           }
       });
   }

   private ServicesFactory(){
       optInjector = Optional.empty();
   }

   public UserServices getUserServices(){
       if (!optInjector.isPresent()) {
           optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
       }
       return optInjector.get().getInstance(UserServices.class);
   }

   public static ServicesFactory getInstance(){
       return instance;
   }

    public SessionLogger getLoginServices(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(SessionLogger.class);
    }


}