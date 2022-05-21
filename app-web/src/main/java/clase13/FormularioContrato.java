package clase13;

public class FormularioContrato extends Formulario {

	public FormularioContrato(String nombre) {
		super(nombre);
	}

	@Override
	public void definirEtiquetas() {
		Etiqueta direccion = new Etiqueta("direcccion");
		Etiqueta apellido = new Etiqueta("direcccion");
		Etiqueta nombre = new Etiqueta("direcccion");
		
		super.agregarEtiqueta(new Etiqueta[] {direccion, apellido, nombre});
		super.agregarEtiqueta(apellido);
		super.agregarEtiqueta(nombre);
	}

}
