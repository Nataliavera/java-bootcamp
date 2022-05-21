package ejercicio;

public class Helicoptero extends Volador implements Aterrizable{

	public Helicoptero(String nombre) {
		super(nombre);
	}

	@Override
	public Estado aterrizar() {
		System.out.println("Helipcotero: "+this.getNombre()+ " aterrizando...");
		Estado estado; 
		if(Volador.cont %2 == 0) {
			estado = new Estado(false, "");
		}else {
			estado = new Estado(true, "Valor impar: error "+Volador.cont);
		}
		return estado;
	}
	
	

}
