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

            //”Remember Me” built-in, just do this: 
            token.setRememberMe(true);

            Subject currentUser = SecurityUtils.getSubject(); //Esta función devuelve el nombre de usuario actual.

            // currentUser.getSession().setAttribute("Nombre", nombre);
            //Establece el valor de un atributo en el elemento indicado. Si el atributo ya existe, el valor es actualizado, en caso contrario, el nuevo atributo es añadido con el nombre y valor indicado.

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