package clase19;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapMain {

	public static void main(String[] args) {

		/**
		 * ASOCIAR LOS DIAS DE LA SEMANA
		 * 
		 * NO PUEDO CARGAR DOS CLAVES IGUALES, DEBE DE SER UNICA
		 */

		Map<Integer, String> mapSemana = new HashMap<Integer, String>();

		mapSemana.put(1, "Lunes");
		mapSemana.put(2, "Martes");
		mapSemana.put(3, "Miercoles");
		mapSemana.put(4, "Jueves");
		mapSemana.put(5, "Viernes");
		mapSemana.put(6, "Sabado");
		mapSemana.put(7, "Domingo");

		System.out.println(mapSemana);// toString

//		DETERMINAR SI EXISTE UNA CLAVE DENTRO DE UN MAPA
		boolean existeK = mapSemana.containsKey(4);
		System.out.println(existeK);

//		ELIMINAR UNA CLAVE-VALOR 
		String value = mapSemana.remove(3);
		System.out.println(mapSemana);

//		VACIAR EL MAPA 
//		mapSemana.clear();

		mapSemana.replace(6, "Saturday");

//		PUEDO OBTENER TODAS LAS CLAVES -> DEVUELVE UN SET<> keySet()
		Set<Integer> keys = mapSemana.keySet();
		System.out.println("Claves del mapa: " + keys);

//		TAMBIEN PUEDO OBTENER TODAS LOS VALORES -> DEVULEVE UNA COLLECTION
		Collection<String> values = mapSemana.values();
		System.out.println("Valores del mapa: " + values);

//		RECORRER EL MAPA USANDO SUS CLAVES 
		for (Integer oneKey : keys) {
			String oneValue = mapSemana.get(oneKey);
			System.out.println("Key: " + oneValue+ " Value:"+oneValue);
//			mapSemana.put(oneKey*10, value + " - "+oneKey);
//			DENTRO DE UN FOR NO PUEDO AGREGAR NUEVOS VALORES A LOS MAPAS 
		}
		
		System.out.println(mapSemana);
		
//		RECORRIDO POR VALOR 
		for(String oneValues: values) {
			System.out.println("Value: "+oneValues);
		}

//		ENTRY -> PERTENECE A LA CLASE MAP 
//		PERMITE RECORRER EL MAPA 
		Set<Map.Entry<Integer, String>> entrySet = mapSemana.entrySet();
		
//		RECORRER LAS ENTRADAS DE UN MAPA USANDO ENTRY 
		for(Map.Entry<Integer, String> oneEntry : entrySet) {
			Integer oneKey =oneEntry.getKey();
			String oneValue = oneEntry.getValue();
			
			System.out.println(oneKey+ " - "+oneValue);
		}
		
		 
		
	}

}
