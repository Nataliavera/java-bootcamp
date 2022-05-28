package practicas_collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {

		Equipos e1 = new Equipos("Equipo 1", 20);
		Equipos e2 = new Equipos("Equipo 2", 50);
		Equipos e3 = new Equipos("Equipo 3", -10);
		Equipos e4 = new Equipos("Equipo 4", 85);
		Equipos e5 = new Equipos("Equipo 5", 0);
		Equipos e6 = new Equipos("Equipo 6", 13);

		Collection<Equipos> equipos = new TreeSet<Equipos>(new CollectionCustom());

		equipos.add(e1);
		equipos.add(e2);
		equipos.add(e3);
		equipos.add(e4);
		equipos.add(e5);
		equipos.add(e6);

		Iterator<Equipos> itEquipos = equipos.iterator();
		while (itEquipos.hasNext()) {
			Equipos e = itEquipos.next();
			System.out.println(e);
		}

		while (itEquipos.hasNext()) {
			Equipos e = itEquipos.next();
			System.out.println(e + " Elemento eliminado");
			itEquipos.remove();
		}

		int tamanio = equipos.size();
		System.out.println("Tamaño del array: " + tamanio);

		boolean vacio = equipos.isEmpty();
		System.out.println(vacio);

		equipos.add(new Equipos("Equipo 7", 45));

		equipos.removeAll(equipos);
		System.out.println(equipos.isEmpty());
		
	
		
	}

}
