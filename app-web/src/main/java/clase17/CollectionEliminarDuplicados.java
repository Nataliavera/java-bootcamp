package clase17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class CollectionEliminarDuplicados {
// SECUENCIAL, PERO NO ENLAZADA 
//	CON MUCHOS ELEMENTOS ES MUY LENTO > PARA VELOCIDAD SE UTILIZA UN ARRAYLIST 
	public static void main(String[] args) {

		Collection<String> nombres = new LinkedList<>();

		nombres.add("carlos");
		nombres.add("juan");
		nombres.add("jose");
		nombres.add("maria");
		nombres.add("brian");
		nombres.add("carlos");

		System.out.println(nombres);

//		QUIERO ELIMINAR LOS ELEMENTOS DUPLICADPS 
		nombres = new HashSet<>(nombres);
		System.out.println(nombres);

//		SI LA COLLECTION CONTIENE UN ELEMENTO 
		boolean comprobar = nombres.contains("pepe");

		System.out.println(comprobar);

		Collection<String> apellidos = new LinkedList<>();

		apellidos.add("matias");
		apellidos.add("brenda");
		apellidos.add("giuliana");
		apellidos.add("andres");
		
		
//		COMBINO DOS LISTAS EN UNA LISTA 
//		apellidos.addAll(nombres);
		
		Collection<String> apyn = new ArrayList<String>();
		apyn.addAll(nombres);
		apyn.addAll(apellidos);
		
		System.out.println(apyn);
		
//		CONTIENE TODOS LOS ELEMENTOS DE UNA COLECCION
		nombres.containsAll(apyn);
		
	}

}
