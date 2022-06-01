package clase20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Vendedores {

	private Collection<String> vendedores;

	public Vendedores() {
		vendedores = new HashSet<String>();

//		PRIMERA LINEA DEL ARCHIVO
		vendedores.add("id|nombre|sucursal");
		vendedores.add("1|Juan|1");
		vendedores.add("2|Pedro|1");
		vendedores.add("3|Nicolas|2");
		vendedores.add("4|Andres|3");

	}

//	NECESITO UN METODO PUBLICO PARA ACCEDER 
	public Collection<Vendedor> getVendedores() {
		for (int i = 1; i < this.vendedores.size(); i++) {

		}
		
//		OTRA FORMA 
		Collection<Vendedor> vendedores = new ArrayList<Vendedor>();
		
		Iterator<String> itVendedores = this.vendedores.iterator();
		if (itVendedores.hasNext()) {
			String primeraLinea = itVendedores.next();
			while (itVendedores.hasNext()) {
				String siguienteLinea = itVendedores.next();
				
				Vendedor v = new Vendedor(siguienteLinea);
				vendedores.add(v);
//				String[] arrayVendedor = siguienteLinea.split("\\|");
//				
//				Long id = Long.parseLong(arrayVendedor[0]);
//				String nombre = arrayVendedor[1];
//				int sucursal= Integer.parseInt(arrayVendedor[2]);
				
//				CREAR UN VENDEDOR 
//				Vendedor unVendedor = new Vendedor(id, nombre, sucursal);
//				vendedores.add(unVendedor);
				
//				CONVERTIR LOS DATOS DEL ARRAY EN EL TIPO CORRECTO 

//				SETEAR EN EL VENDEDOR EL DATO CORRESPONDIENTE 
			}

		}
		return vendedores;
	}

}
