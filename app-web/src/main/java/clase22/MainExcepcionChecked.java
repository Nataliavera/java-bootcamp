package clase22;

public class MainExcepcionChecked {

	public static void main(String[] args) throws Exception {
		
		saludar(null);
	}
	
	static void saludar(String saludo) throws Exception{
		if(saludo == null) {
			throw new Exception("No informa saludo");
		}else {
			System.out.println("Mostrando saludo = "+saludo);
		}
	}
}
