package clase15.generic;

public class ServicetTablaX extends Service<TablaX>{

	
//	ES PARA LA TABLA X
	public ServicetTablaX() {
		super(new TablaXImpl());
	}
	
	public TablaX consultarPorId(Long id) {
		return this.iTabla.buscarPorID(id);
	}
}
