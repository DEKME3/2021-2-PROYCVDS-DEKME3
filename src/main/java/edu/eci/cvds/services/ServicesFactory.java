package edu.eci.cvds.services;

import com.google.inject.Injector;
import org.mybatis.guice.XMLMyBatisModule;

import edu.eci.cvds.Persistence.CategoryDao;
import edu.eci.cvds.Persistence.NeedDao;
import edu.eci.cvds.Persistence.OfferDao;
import edu.eci.cvds.Persistence.RespuestaDao;
import edu.eci.cvds.Persistence.UserDao;
import edu.eci.cvds.Persistence.UserTypeDao;
import edu.eci.cvds.Persistence.myBatisImple.MyBatisCategory;
import edu.eci.cvds.Persistence.myBatisImple.MyBatisNeed;
import edu.eci.cvds.Persistence.myBatisImple.MyBatisOffer;
import edu.eci.cvds.Persistence.myBatisImple.MyBatisRespuesta;
import edu.eci.cvds.Persistence.myBatisImple.MyBatisUser;
import edu.eci.cvds.Persistence.myBatisImple.MyBatisUserType;
import edu.eci.cvds.authenticator.SessionLogger;
import edu.eci.cvds.authenticator.ShiroSession;
import edu.eci.cvds.services.impl.CategoryServicesImpl;
import edu.eci.cvds.services.impl.OfferServicesImpl;
import edu.eci.cvds.services.impl.RespuestaServicesImpl;
import edu.eci.cvds.services.impl.UserServicesImpl;
import edu.eci.cvds.services.impl.NeedServicesImpl;
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
               bind(NeedDao.class).to(MyBatisNeed.class);
               bind(CategoryDao.class).to(MyBatisCategory.class);
               bind(OfferDao.class).to(MyBatisOffer.class);
               bind(NeedDao.class).to(MyBatisNeed.class);
               bind(OfferDao.class).to(MyBatisOffer.class);
               bind(RespuestaDao.class).to(MyBatisRespuesta.class);
               bind(UserServices.class).to(UserServicesImpl.class);
               bind(CategoryServices.class).to(CategoryServicesImpl.class);
               bind(OfferServices.class).to(OfferServicesImpl.class);
               bind(RespuestaServices.class).to(RespuestaServicesImpl.class);
               bind(NeedServices.class).to(NeedServicesImpl.class);
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

   public CategoryServices getCategoryServices(){
    if (!optInjector.isPresent()) {
        optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
    }
    return optInjector.get().getInstance(CategoryServices.class);
   }

   public OfferServices getOfferServices(){
    if (!optInjector.isPresent()) {
        optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
    }
    return optInjector.get().getInstance(OfferServices.class);
   }
   
   public NeedServices getNeedServices(){
	    if (!optInjector.isPresent()) {
	        optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
	    }
	    return optInjector.get().getInstance(NeedServices.class);
	}

   public RespuestaServices getRespuestaServices(){
	    if (!optInjector.isPresent()) {
	        optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
	    }
	    return optInjector.get().getInstance(RespuestaServices.class);
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