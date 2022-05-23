package clase15;

public class Main {

	public static void main(String[] args) {

		String tipo = "";
		
		if("x".equals(tipo)) {
			ServicioXImpl servicio = new ServicioXImpl();
			servicio.parse();
		}else {
			ServicioYImpl servicio = new ServicioYImpl();
			servicio.parse();
		}
	}

}
