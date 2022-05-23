package clase14;

public class Main {

	public static void main(String[] args) {
		
//		CREAR UNA PERSONA 
		Persona p = new Persona("Natalia", new Español()); // IDIOMA NATIVO
		
//		DECIR HOLA EN EL IDIOMA NATIVO
		p.decir("Hola");
		
//		APRENDA UN IDIOMA 
		p.aprenderIdioma(new Ingles());
		
//		DECIR ALGO EN EL NUEVO IDIOMA
		p.decir("algo", new Ingles());
		p.decir("algo", new Italiano());
		
		
//		DECIR ALGO EN TODOOS LOS IDIOMAS 
		p.decirEnTodos("algo");
	}
}
