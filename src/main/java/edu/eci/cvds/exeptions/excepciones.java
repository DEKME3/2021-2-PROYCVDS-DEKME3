package edu.eci.cvds.exeptions;

public class excepciones extends Exception {
	
	public excepciones() {
		super();
	}

	public excepciones(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public excepciones(String message, Throwable cause) {
		super(message, cause);
	}

	public excepciones(String message) {
		super(message);
	}

	public excepciones(Throwable cause) {
		super(cause);
	}
}
