package clase13;

public abstract class Formulario {

	private String nombre;
	private Etiqueta[] etiquetas;
	static Integer cont = 0; 

	public Formulario(String nombre) {
		super();
		this.etiquetas = new Etiqueta[] {};
		this.nombre = nombre;
		Formulario.cont++;
	}

	public abstract void definirEtiquetas();

	public void agregarEtiqueta(Etiqueta[] etiquetas2) {
		this.etiquetas = etiquetas2;
//		VER COMO IMPLEMENTAR
	}

	public void agregarEtiqueta(Etiqueta apellido) {
		Etiqueta[] nuevas = new Etiqueta[etiquetas.length + 1];
		for (int i = 0; i < etiquetas.length; i++) {
			nuevas[i] = etiquetas[i];
		}
		nuevas[etiquetas.length] = apellido;
	}

	public String compilarEtiquetas() {
		
		StringBuffer texto = new StringBuffer(this.nombre);
		
		for(Etiqueta e: etiquetas) {
			texto.append(e.getTag());
			texto.append(" , ");
		}
		return texto.toString();
	}

}
