package clase17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionMain2 {

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
		
//		ELIMINAR DE MANERA SEGURA 
//		1 - me conecto a la collection por medio del metodo iterator()
		Iterator<String> itNombres = nombres.iterator();
		while(itNombres.hasNext()) {
//			MIENTRAS TENGA UN ELEMENTO
			String nombreActual = itNombres.next();
			System.out.println("Eliminando "+itNombres);
			itNombres.remove();
		}
		
//		DETERMINA SI LA COLLECTION ESTA VACIA 
		boolean vacio =nombres.isEmpty();//boolean
			
		
		
	}

}
