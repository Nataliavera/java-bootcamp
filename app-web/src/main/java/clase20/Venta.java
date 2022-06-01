package clase20;

import java.util.Date;

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
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
