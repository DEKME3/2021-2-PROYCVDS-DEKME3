package edu.eci.cvds.ManageBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.entities.UserType;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;
import edu.eci.cvds.services.ServicesFactory;
import edu.eci.cvds.services.UserServices;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import org.primefaces.PrimeFaces;

import java.io.IOException;

@SuppressWarnings("deprecation")
@ManagedBean(name = "UserBeans")
@SessionScoped

public class UserBeans {
	
	private UserServices userServices= ServicesFactory.getInstance().getUserServices(); 
    private String name;
    private String password;
    private int idName; 
    private int numeroNecesidades;
	private String nombreUsuarioLogin;
	private int idUserLogin;
	private int idUserTypeLogin;
    
	
	public UserBeans(){}
    
	

	public UserServices getUserServices() {
		return userServices;
	}



	public void setUserServices(UserServices userServices) {
		this.userServices = userServices;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getIdName() {
		return idName;
	}



	public void setIdName(int idName) {
		this.idName = idName;
	}



	public int getNumeroNecesidades() {
		return numeroNecesidades;
	}



	public void setNumeroNecesidades(int numeroNecesidades) {
		this.numeroNecesidades = numeroNecesidades;
	}



	public String getNombreUsuarioLogin() {
		return nombreUsuarioLogin;
	}



	public void setNombreUsuarioLogin(String nombreUsuarioLogin) {
		this.nombreUsuarioLogin = nombreUsuarioLogin;
	}



	public int getIdUserLogin() {
		return idUserLogin;
	}



	public void setIdUserLogin(int idUserLogin) {
		this.idUserLogin = idUserLogin;
	}



	public int getIdUserTypeLogin() {
		return idUserTypeLogin;
	}



	public void setIdUserTypeLogin(int idUserTypeLogin) {
		this.idUserTypeLogin = idUserTypeLogin;
	}



	public void logIn() throws ExcepcionesSolidaridad{
        try{
            if(userServices.validateLogin(name,password)){
                System.out.println("Validacion ok");
                User user = userServices.getUser(name);
                switch (user.getUserType().getName()) {
                    case "Administrador":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("menu.xhtml");
                        break;
                    case "Estudiante":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("necesidad.xhtml");
                        break;
                }
            }else{
                System.out.println("Fallo de Validacion");
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsp");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	private void obtenerDatosUsuario() throws ExcepcionesSolidaridad {
		Subject currentUser = SecurityUtils.getSubject();
		setNombreUsuarioLogin((String) currentUser.getSession().getAttribute("Nombre"));
		setIdUserLogin(userServices.getIdUserByName(getNombreUsuarioLogin()));
		setIdUserTypeLogin(userServices.getIdUserTypeByIdUser(getIdUserLogin()));
	}
    
    public void updateNeed() throws ExcepcionesSolidaridad {
    	obtenerDatosUsuario();
    	int idTypeUserActualizar = userServices.getIdUserTypeByIdUser(idName);
    	if(getIdUserTypeLogin() == 1 && idTypeUserActualizar == 2 ) {
    		userServices.ActualizarNeedUserByName(idName, numeroNecesidades);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cambio de número de necesidades", "El número de necesidades del usuario con id " + idName + " fue actualizado");
            PrimeFaces.current().dialog().showMessageDynamic(message);	
    	}
		else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No se pudo modificar el numero de necesidades del usuario");
            PrimeFaces.current().dialog().showMessageDynamic(message);	
		}
    }

	@RequiresGuest
	public void redirigirReportes(){
		try {
			Subject currentUser = SecurityUtils.getSubject();
			String nombreUsuario = (String) currentUser.getSession().getAttribute("Nombre");
			int idUser = userServices.getIdUserByName(nombreUsuario);
			int userType = userServices.getIdUserTypeByIdUser(idUser);
			if (userType == 1) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/reportes.xhtml");
			} else {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No puede acceder a los reportes ya que no cuenta con los permisos de administrador");
            	PrimeFaces.current().dialog().showMessageDynamic(message);	
			}
		} catch (ExcepcionesSolidaridad | IOException e) {
			e.printStackTrace();
		}
	}


}