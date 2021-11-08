package edu.eci.cvds.exeptions;

public class ExcepcionesSolidaridad extends Exception {
	
	public ExcepcionesSolidaridad() {
		super();
	}

	public ExcepcionesSolidaridad(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ExcepcionesSolidaridad(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcepcionesSolidaridad(String message) {
		super(message);
	}

	public ExcepcionesSolidaridad(Throwable cause) {
		super(cause);
	}
}
