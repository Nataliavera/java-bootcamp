package ar.com.educacionit.domain;

import java.util.Date;


public class Articulo implements Entity{

	private Long id;
	private String titulo;
	private String codigo;
	private Date fechaCreacion;
	private Double precio;
	private Long stock;
	private Long marcasId;
	private Long categoriasId;

//	CONSTRUCTOR SIN ID YA QUE LA BASE DE DATOS SE ENCARGA DE GENERAR EL ID
	public Articulo(String titulo, String codigo, Date fechaCreacion, Double precio, Long stock, Long marcasId,
			Long categoriasId) {
		super();
		this.titulo = titulo;
		this.codigo = codigo;
		this.fechaCreacion = fechaCreacion;
		this.precio = precio;
		this.stock = stock;
		this.marcasId = marcasId;
		this.categoriasId = categoriasId;
	}

//	CONSTRUCTOR CON ID PARA CUANDO OBTENGA LOS DATOS 
	public Articulo(Long id, String titulo, String codigo, Date fechaCreacion, Double precio2, Long stock2, Long marcasId2,
			Long categoriasId2) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.codigo = codigo;
		this.fechaCreacion = fechaCreacion;
		this.precio = precio2;
		this.stock = stock2;
		this.marcasId = marcasId2;
		this.categoriasId = categoriasId2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Long getMarcasId() {
		return marcasId;
	}

	public void setMarcasId(Long marcasId) {
		this.marcasId = marcasId;
	}

	public Long getCategoriasId() {
		return categoriasId;
	}

	public void setCategoriasId(Long categoriasId) {
		this.categoriasId = categoriasId;
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", titulo=" + titulo + ", codigo=" + codigo + ", fechaCreacion=" + fechaCreacion
				+ ", precio=" + precio + ", stock=" + stock + ", marcasId=" + marcasId + ", categoriasId="
				+ categoriasId + "]";
	}

}
