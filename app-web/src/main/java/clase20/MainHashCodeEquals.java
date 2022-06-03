package clase20;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MainHashCodeEquals {

	public static void main(String[] args) {

		Set<Venta> ventas = new HashSet<>();
		
		Date date = new Date();
//		DOS VENTAS CON EL MISMO IDENTIFICADOR
//		SON DISTINTOS A NIVEL DE MEMORIA POR EL NEW
		Venta v1 = new Venta(1L, date,1500D);
		Venta v2 = new Venta(1L, date,2500D);
		
		ventas.add(v1);
		ventas.add(v2);
		
		System.out.println(ventas);
	}

}
