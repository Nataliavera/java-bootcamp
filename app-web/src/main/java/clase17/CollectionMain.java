package clase17;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionMain {

	public static void main(String[] args) {

//		JAVA COLLECTION FRAMEWORK 
//		COLLECTIO<T> CUALQUIER COSA 
//			LISTA<T> : ADMITE ELEMENTOS DUPLICADOS 
//				- ARRAYLIST<T>
//				-LINKEDLIST<T>
//			SET<U> :  NO ADMITE DUPLICADOS 
//		MAP<K,V>: ASOCIA CLAVE, VALOR 
		
		
//		1- CREAR UNA COLLECTION<STRING>
		Collection<String> nombres = new ArrayList<String>();
		
//		2- AGREGAR ELEMENTOS 
		nombres.add("brenda");
		nombres.add("walter");
		nombres.add("nicolas");
		
//		3- TAMAÑO 
		int tamanio = nombres.size();
		System.out.println("Tamanio: "+tamanio);
		
//		4- RECORRER A
		for(String nombre : nombres) {
			System.out.print(nombre+ " ");
		}
		
//		5- ELIMINAR
		nombres.remove("walter");
		
//		5.1- ELIMINAR TODOS 
		nombres.clear();
		
//		ELIMINAR DENTRO DE UN CICLO
		
		
		tamanio = nombres.size();
		System.out.println("\nAhora: "+tamanio);
		
	}

}
