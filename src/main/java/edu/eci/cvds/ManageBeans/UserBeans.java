package edu.eci.cvds.ManageBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;
import edu.eci.cvds.services.ServicesFactory;
import edu.eci.cvds.services.UserServices;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.io.IOException;

@SuppressWarnings("deprecation")
@ManagedBean(name = "UserBeans")
@SessionScoped

public class UserBeans {
	
	private UserServices userServices= ServicesFactory.getInstance().getUserServices(); //es una clase abstracta que proporciona una fábrica para la creación de instancias del tipo javax.xml.rpc.Service.
    private String name;
    private String password;
    private int idName; 
    private int numeroNecesidades;
	private String nombreUsuarioLogin;
	private int idUserLogin;
	private int idUserTypeLogin;
    
	
	public UserBeans(){}
    
	
    public int getIdUserTypeLogin() {
		return idUserTypeLogin;
	}

	public void setIdUserTypeLogin(int idUserTypeLogin) {
		this.idUserTypeLogin = idUserTypeLogin;
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

	public int getNameuser() {
		return idName;
	}

	public void setNameuser(int idName) {
		this.idName = idName;
	}

	public int getNumeroNecesidades() {
		return numeroNecesidades;
	}

	public void setNumeroNecesidades(int numeroNecesidades) {
		this.numeroNecesidades = numeroNecesidades;
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
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsp"); // para representar toda la información contextual asociada con el procesamiento de una solicitud entrante y crear la respuesta correspondiente.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	private void obtnerDatosUsuario() throws ExcepcionesSolidaridad {
		Subject currentUser = SecurityUtils.getSubject();
		setNombreUsuarioLogin((String) currentUser.getSession().getAttribute("Nombre"));
		setIdUserLogin(userServices.getIdUserByName(getNombreUsuarioLogin()));
		setIdUserTypeLogin(userServices.getIdUserTypeByIdUser(getIdUserLogin()));
	}
    
    public void updateNeed() throws ExcepcionesSolidaridad {
    	obtnerDatosUsuario();
    	int idTypeUserActualizar = userServices.getIdUserTypeByIdUser(idName);
    	if(getIdUserTypeLogin() == 1 && idTypeUserActualizar == 2 ) {
    		userServices.ActualizarNeedUserByName(getNameuser(), getNumeroNecesidades());
    	}
    }


}