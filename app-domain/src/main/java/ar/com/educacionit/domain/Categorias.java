package ar.com.educacionit.domain;

public class Categorias {

	private Long id;
	private String descripcion;
	private Long habilitada;

	public Categorias() {
		super();
	}

	public Categorias(Long id, String descripcion, Long habilitada) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.habilitada = habilitada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getHabilitada() {
		return habilitada;
	}

	public void setHabilitada(Long habilitada) {
		this.habilitada = habilitada;
	}

	
}
