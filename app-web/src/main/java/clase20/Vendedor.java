package clase20;

public class Vendedor {

	private Long id;
	private String nombre;
	private Integer sucursal;

	public Vendedor() {
		super();
	}

	public Vendedor(Long id, String nombre, Integer sucursal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sucursal = sucursal;
	}

	public Vendedor(String siguienteLinea) {
//		control
		if (siguienteLinea != null) {
			String[] arrayVendedor = siguienteLinea.split("\\|");
			if (arrayVendedor.length == 3) {
				this.setId(arrayVendedor[0]);
				this.setNombre(arrayVendedor[1]);
				this.setSucursal(arrayVendedor[2]);
			}
		}
	}

	private void setId(String idStr) {
//		isBlank -> SIN DATOS
		if (idStr != null && !idStr.isBlank()) {
//			Character.isDigit(0)
			this.id = Long.parseLong(idStr);
		} else {
//			GENERAR UNA EXCEPCION
			System.err.println("invalid_id_vendedor");
		}

	}

	private void setNombre(String nombre) {
		if (nombre != null) {
			this.nombre = nombre.toLowerCase();
		} else {
			System.err.println("invalid_name_vendedor");
		}
	}

	private void setSucursal(String sucursal) {
		if (sucursal != null) {
			this.sucursal = Integer.parseInt(sucursal);
		} else {
//			GENERAR UNA EXCEPCION
			System.err.println("invalid_sucursal_vendedor");
		}
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getSucursal() {
		return sucursal;
	}

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", nombre=" + nombre + ", sucursal=" + sucursal + "]";
	}
	

}
