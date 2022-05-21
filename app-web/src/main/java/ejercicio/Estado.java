package ejercicio;

public class Estado {

	private boolean error; 
	private String msj;
	
	public Estado(boolean error, String msj) {
		super();
		this.error = error;
		this.msj = msj;
	}
	public boolean isError() {
		return error;
	}
	public String getMsj() {
		return msj;
	} 
	
//	INMUTABLE PORQUE NO TIENE SETTERS 
}
