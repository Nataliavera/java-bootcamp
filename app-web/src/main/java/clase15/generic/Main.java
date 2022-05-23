package clase15.generic;

public class Main {

	public static void main(String[] args) {

		ServicetTablaX sx = new ServicetTablaX();
		TablaX tx =  sx.consultarPorId(1L);
		
		ServicetTablaY sy = new ServicetTablaY();
		TablaY ty =  sy.consultarPorId(2L);
		
	}

}
