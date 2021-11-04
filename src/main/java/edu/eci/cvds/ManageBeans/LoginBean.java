package edu.eci.cvds.ManageBeans;

import edu.eci.cvds.authenticator.SessionLogger;
import edu.eci.cvds.dao.mybatis.mappers.UserMapper;
import edu.eci.cvds.exeptions.excepciones;
import edu.eci.cvds.services.ServicesFactory;
import edu.eci.cvds.services.client.MyBatisPrueba;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.google.inject.Inject;
import java.io.IOException;



@SuppressWarnings("deprecation")
@SessionScoped
@ManagedBean(name ="LoginBean")

public class LoginBean {

    private static final long serialVersionUID = -2084921068710522276L;


    public String nombre;
    public String clave;
    public boolean logg;

    // @Inject
    // private SessionLogger logger;

    private SessionLogger logger = ServicesFactory.getInstance().getLoginServices();

    public LoginBean() {
    }

    public Subject getCurrentUser(){
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser;
    }

    public SessionLogger getLogger() {
        return logger;
    }

    public void setLogger(SessionLogger logger) {
        this.logger = logger;
    }

    public String getNombre() {
        return nombre;
    }
    public String getClave(){
        return clave;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setClave(String clave){
        this.clave=clave;
    }

    public boolean isLogg() {
		return logg;
	}

	public void setLogg(boolean logg) {
		this.logg = logg;
	}

    @RequiresGuest
    public void login() throws excepciones {
        try {
            logger.login(nombre,clave);
            setLogg(true);
            // String rolUsuario = MyBatisPrueba.validarUserType(nombre).getName();
            // switch(rolUsuario) {
            // 	case "Administrador":
            FacesContext.getCurrentInstance().getExternalContext().redirect("/mainAdministrador.jsp");
            // 	break;
            // }
             
        } catch (excepciones | IOException e){
            FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no encontrado", "Este Usuario no se encuentra en la base de datos."));
        }

    }


    public void activeSession () throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("");
    }
    public void volver(){
        try{
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
            setNombre(null);
            setClave(null);
            SecurityUtils.getSubject().logout();
            logger.logout();
            setLogg(false);
        }catch (Exception e){
            setErrorMessage(e);
        }

    }
    public void retroceder(){
        if(isLogged()){
            try{
            	FacesContext.getCurrentInstance().getExternalContext().redirect("/mainAdministrador.jsp");
            }catch (IOException e){
                setErrorMessage(e);
            }
        }
    }
    public boolean isLogged(){
        return logger.isLogged();
    }
    
    public void logout() throws IOException{
        if(isLogged()){
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.jsp");
            SecurityUtils.getSubject().logout();
        }
    }
    protected static void setErrorMessage(Exception e) {
        String message = e.getMessage();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }

	// public void validarLogin(String nombre, String clave) throws excepciones {
	// 	setNombre(nombre);
	// 	setClave(clave);
	// 	System.out.println(nombre);
	// 	System.out.println(clave);
	// 	login();
	// }
}