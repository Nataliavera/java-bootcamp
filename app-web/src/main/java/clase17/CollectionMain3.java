package clase17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionMain3 {

	public static void main(String[] args) {

		Collection<String> nombres = new ArrayList<String>();
		Collection<String> nombresEliminados = new ArrayList<String>();

		nombres.add("brenda");
		nombres.add("walter");
		nombres.add("nicolas");
		
//	ELIMINAR LOS ELEMENTOS Y PASARLA A OTRA COLLECTION
		Iterator<String> itNombres = nombres.iterator();
		while(itNombres.hasNext()) {
//			MIENTRAS TENGA UN ELEMENTO
			String nombreActual = itNombres.next();
			System.out.println("Eliminando "+nombreActual);
			itNombres.remove();
			nombresEliminados.add(nombreActual);
		}
		
		Iterator<String> itNombresE = nombresEliminados.iterator();
		while(itNombresE.hasNext()) {
			String n = itNombresE.next();
			System.out.println(n);
		}
		
		System.out.println("Otra collection:"+nombresEliminados);
		
		
	}

}
