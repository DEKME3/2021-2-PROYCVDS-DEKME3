package edu.eci.cvds.authenticator;
import edu.eci.cvds.exeptions.excepciones;

public interface SessionLogger {
	
    public void login(String nombre, String clave) throws excepciones;

    public boolean isLogged();

    public void logout();
}
