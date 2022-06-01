package clase20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VendedoresMainTest {

	public static void main(String[] args) {

		Vendedores archivoVendedores = new Vendedores();

		Collection<Vendedor> vendedores = archivoVendedores.getVendedores();

		Ventas archivoVentas = new Ventas();
		Collection<Venta> ventas = archivoVentas.getVentas();

//		RECORRO LAS VENTAS Y CON EL ID DEL VENDEDOR BUSCO EN LA COLLECTION DE VENTAAS
		Map<Vendedor, Collection<Venta>> mapVentasXVendedor = new HashMap<>();

//			CARGAR PARA CADA VENDEDOR LAS VENTAS QUE TIENE
		for (Vendedor vendedor : vendedores) {
			mapVentasXVendedor.put(vendedor, new ArrayList<>()); // POR CADA VENDEDOR CARGAR UN ARRAY VACIO
			for (Venta venta : ventas) {
				if (vendedor.getId().equals(venta.getIdVendedor())) {
//					AGREGAR AL MAPA 
//						SI NO CONTIENE AL VENDEDOR AGREGARLO CON LAS VENTAS QUE TIENE
//						Collection<Venta> ventasDelVendedor = new ArrayList<>();
//						ventasDelVendedor.add(venta);

//						PEDIRLE AL MAPA LOS VALUES() Y AGREGARLE LA VENTA
					mapVentasXVendedor.get(vendedor).add(venta);

//						AL MAPA 
					mapVentasXVendedor.put(vendedor, ventas);
				}
			}
		}

		System.out.println(vendedores);
		System.out.println(ventas);

	}

}
