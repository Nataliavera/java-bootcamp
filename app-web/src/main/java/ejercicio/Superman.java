package ejercicio;

public class Superman extends Volador implements Aterrizable{

	public Superman(String nombre) {
		super(nombre);
	}

	@Override
	public Estado aterrizar() {
		System.out.println("Superman aterrizando...");
		Estado estado; 
		if(Volador.cont %2 == 0) {
			estado = new Estado(false, "");
		}else {
			estado = new Estado(true, "Valor impar: error "+Volador.cont);
		}
		return estado;
	}


}
