package practicas_collections;

public class Equipos {

	private String nombreEquipo;
	private int puntaje;

	public Equipos(String nombreEquipo, int puntaje) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.puntaje = puntaje;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	@Override
	public String toString() {
		return "Equipos [nombreEquipo=" + nombreEquipo + ", puntaje=" + puntaje + "]";
	}

}
