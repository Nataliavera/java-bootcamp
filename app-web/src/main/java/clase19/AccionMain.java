package clase19;

public class AccionMain {

	/**
	 * EL USUARIO INGRESA UNA OPCION 
	 * 1- ALTA 
	 * 2- BAJA 
	 * 3- MODIFICAR 
	 * 4- LISTAR 
	 * 
	 * SINO 
	 * ACCION DEFAULT 
	 * @param args
	 */
	public static void main(String[] args) {

		Integer opIngresadaUsuario = 1; 
		
		IAccion accion =  AccionMap.getAccion(opIngresadaUsuario);
		
//		execute
//		accion.exec("ejecutando");
	}

}
