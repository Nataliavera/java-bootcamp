package ejercicio;

public class CreadorDeVoladores {

	public static Volador[] crearVoladores() {
		Avion  avion = new Avion("Avion1");
		Helicoptero h1 = new Helicoptero("Avion1");
		Superman s = new Superman("s1");
		Ovni o = new Ovni();
		
		Volador[] voladores = {avion, h1,s, o};
		
		return voladores;
	}

}
