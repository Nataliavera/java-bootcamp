package ejercicio;

public class Avion extends Volador implements Aterrizable{

	private Integer cantidadAsientos;
	
	public Avion(String nombre) {
		super(nombre);
	}

	@Override
	public Estado aterrizar() {
		System.out.println("Avion: "+this.getNombre()+ " aterrizando...");
		Estado estado; 
		if(Volador.cont %2 == 0) {
			estado = new Estado(false, "");
		}else {
			estado = new Estado(true, "Valor impar: error "+Volador.cont);
		}
		return estado;
	}

}
