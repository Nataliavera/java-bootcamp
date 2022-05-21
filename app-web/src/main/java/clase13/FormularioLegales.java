package clase13;

public class FormularioLegales extends Formulario{

	public FormularioLegales(String nombre) {
		super(nombre);
	}

	@Override
	public void definirEtiquetas() {
		Etiqueta apellido = new Etiqueta("direcccion");
		Etiqueta nombre = new Etiqueta("direcccion");
		
		super.agregarEtiqueta(apellido);
		super.agregarEtiqueta(nombre);
	}

}
