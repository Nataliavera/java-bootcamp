package ar.com.educacionit.domain;

public class Socios implements Entity {

	private Long id;
	private String nombre;
	private String apellido;
	private String codigo;

	@Override
	public String toString() {
		return "Socios [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", codigo=" + codigo + "]";
	}

	public Socios() {
		super();
	}

	public Socios(String nombre, String apellido, String codigo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.codigo = codigo;
	}

	public Socios(Long id, String nombre, String apellido, String codigo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
