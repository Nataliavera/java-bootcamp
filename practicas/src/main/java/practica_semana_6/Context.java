package practica_semana_6;

public class Context {

	private String id; 
	private String edad; 
	private Float monto;
	
	public Context(String id, String edad, Float monto) {
		super();
		this.id = id;
		this.edad = edad;
		this.monto = monto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Context [id=" + id + ", edad=" + edad + ", monto=" + monto + "]";
	}

	

	
	
	
}
