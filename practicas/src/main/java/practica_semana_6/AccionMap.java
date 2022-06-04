package practica_semana_6;

import java.util.HashMap;
import java.util.Map;

public class AccionMap {
	
	static Map<Integer, IAccion> mapAccion = construirAcciones();

	private static Map<Integer, IAccion> construirAcciones(){
		Map<Integer,IAccion> mapAcciones = new HashMap<Integer, IAccion>();
//		CARGO EL MAPA CON LAS OPCIONES
		mapAcciones.put(1, new AccionAlta());
		mapAcciones.put(2, new AccionBaja());
		mapAcciones.put(3, new AccionModificar());
		mapAcciones.put(4, new AccionListar()); 
		return mapAcciones;
	}
	
	public static IAccion getAccion(Integer op) {
		
		IAccion accion = new AccionPorDefecto(); 
		
		if(mapAccion.containsKey(op)) {
			accion =  mapAccion.get(op);
		}
		
		return accion; 
	}

}
