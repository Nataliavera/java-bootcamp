package clase20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Ventas {

	Collection<String> ventas; 
	
	public Ventas() {
		ventas = new HashSet<String>();

//		PRIMERA LINEA DEL ARCHIVO
		ventas.add("id_vendedor|fecha|monto");
		ventas.add("1|18/04/2022|1500");
		ventas.add("1|15/04/2022|1500");
		ventas.add("1|10/04/2022|14000");
//		ventas.add("4|Andres|3");
	}
	
	public Collection<Venta> getVentas(){
		Collection<Venta> ventas = new ArrayList<Venta>();
		
		Iterator<String> itVentas = this.ventas.iterator();
		if(itVentas.hasNext()) {
			itVentas.next();
			while(itVentas.hasNext()) {
				ventas.add(new Venta(itVentas.next()));
			}
		}
		return ventas;
	}
}
