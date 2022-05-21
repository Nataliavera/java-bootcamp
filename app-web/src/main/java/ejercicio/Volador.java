package ejercicio;

public abstract class Volador {

	private String nombre;
	static int cont = 0; 

	public Volador(String nombre) {
		super();
		this.nombre = nombre;
		Volador.cont ++;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	} 
	
	
}
