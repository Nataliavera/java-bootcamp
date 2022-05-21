package clase12;

public class Dato {

	private Long id; 
	private String descripcion;
	
	public Dato(Long id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		setDescripcion(descripcion);
	} 
	
	public void detalle() {
		System.out.println("ID:"+id);
		System.out.println("descripcion:"+descripcion);
	}

	public Long getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String desc) {
		if(desc != null) {
			this.descripcion = desc.trim();
		}
	}
	
	
}
