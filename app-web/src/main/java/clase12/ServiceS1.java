package clase12;

public class ServiceS1 implements IService {

	@Override
	public Dato consultar() {
//		SUPONER QUE CONSULTAMOS UNA URL Y NOS RETORNA 
//		ID = 1| NOMBRE = JOSE | SUELDO = 1400
		
		String response = "{id=1,nombre=jose,sueldo=1400}";
		
//		PARSING 
		String[] splitted = response.split(",");
	
		Long id = null;
		String descripcion= null;
//		VALIDAR SI RECIBI BIEN LA DATA
		if(splitted.length > 2) {
			String idStr = parseString(splitted[0], "=", 1);
			
			String nombre = parseString(splitted[1], "=", 1);
			
			if(idStr != null) {
				id = Long.parseLong(idStr);
			}
			
			if(nombre != null) {
				descripcion = nombre;
			}
		}
		
		Dato data = new Dato(id, descripcion);
		return new Dato(id, descripcion);
	}
	
	public String parseString(String stringToParse, String deli, int idx) {
		return stringToParse.split(deli)[idx];
	}

}
