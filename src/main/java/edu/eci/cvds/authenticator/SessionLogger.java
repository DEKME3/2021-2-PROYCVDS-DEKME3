package edu.eci.cvds.authenticator;
import edu.eci.cvds.exeptions.ExcepcionesSolidaridad;

public interface SessionLogger {
	
    public void login(String nombre, String clave) throws ExcepcionesSolidaridad;

    public boolean isLogged();

    public void logout();
}
