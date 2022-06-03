package clase20;

import java.util.Date;
import java.util.Objects;

public class Venta {
//GET -> OBJETOS INMUTABLES 

	private Long idVendedor;
//	private Vendedor vendedor; 
	private Date fecha;
	private Double monto;

//	DEBE NACER SI O SI CON LOS DATOS 

	public Venta(String venta) {
// HACER ESTE CONSTRUCTOR
	}

	public Venta(Long idVendedor, Date fecha, Double monto) {
		super();
		this.idVendedor = idVendedor;
		this.fecha = fecha;
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public Double getMonto() {
		return monto;
	}

	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}

	public Long getIdVendedor() {
		return idVendedor;
	}

	@Override
	public int hashCode() {
//IDENTIFICADOR UNICO A NIVEL DE MEMORIA
		return Objects.hash(fecha, idVendedor, monto);
	}

	@Override
	public boolean equals(Object obj) {
//		LOGICA DE NEGOCIO
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
//		SOLO MIRO EL ID
		return this.idVendedor.equals(other.getIdVendedor());
	}


	
}
