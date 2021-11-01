package edu.eci.cvds.ManageBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.exeptions.excepciones;
import edu.eci.cvds.services.ServicesFactory;
import edu.eci.cvds.services.UserServices;
import javax.faces.context.FacesContext;
import java.io.IOException;

@SuppressWarnings("deprecation")
@ManagedBean(name = "UserBeans")
@SessionScoped

public class UserBeans {
	
	private UserServices userServices= ServicesFactory.getInstance().getUserServices(); //es una clase abstracta que proporciona una fábrica para la creación de instancias del tipo javax.xml.rpc.Service.
    private String name;
    private String password;


    public void logIn() throws excepciones{
        try{
            if(userServices.validateLogin(name,password)){
                System.out.println("Validacion ok");
                User user=userServices.getUser(name);
            }else{
                System.out.println("Fallo de Validacion");
                FacesContext.getCurrentInstance().getExternalContext().redirect("SolidaridadEscuela.xhtml"); // para representar toda la información contextual asociada con el procesamiento de una solicitud entrante y crear la respuesta correspondiente.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}