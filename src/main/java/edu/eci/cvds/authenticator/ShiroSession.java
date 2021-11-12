package edu.eci.cvds.authenticator;

import com.google.inject.Inject;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;
import edu.eci.cvds.services.UserServices;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

public class ShiroSession implements SessionLogger{
    
    @Inject
    private UserServices userServices;
    
    public UserServices getUserServices() {
        return userServices;
    }

    public void setUserServices(UserServices userServices) throws ExcepcionesSolidaridad {
        this.userServices = userServices;
    }
	
	@Override
	public void login(String nombre, String clave) throws ExcepcionesSolidaridad {
        try{
            UsernamePasswordToken token = new UsernamePasswordToken( nombre, clave);
            token.setRememberMe(true);
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.getSession().setAttribute("Nombre", nombre);
            currentUser.login(token);                
        } catch ( UnknownAccountException a ) {
            throw new ExcepcionesSolidaridad("El Usuario o Contraseña son incorrectos",a);
        } catch ( IncorrectCredentialsException b ) {
            throw new ExcepcionesSolidaridad("El Usuario o Contraseña son incorrectos",b);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public boolean isLogged() {
		return SecurityUtils.getSubject().isAuthenticated();
	}

	@Override
	public void logout() {
		SecurityUtils.getSubject().logout();
	}

}