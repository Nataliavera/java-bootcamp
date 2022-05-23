package clase14;

//POLIMORFISMO CON SOBRE CARGA DE METODOS 

public class Persona {

	private String nombre;
	private IIdioma idiomaNativo;
	private IIdioma[] masIdiomas;

	public Persona() {
		super();
	}

	public Persona(String nombre, IIdioma idiomaNativo) {
		super();
		this.nombre = nombre;
		this.idiomaNativo = idiomaNativo;
//		NACE SIN IDIOMAS ADICIONALES 
		this.masIdiomas = new IIdioma[]{};
	}

	public void aprenderIdioma(IIdioma nuevoIdioma) {
		if (!existeIdioma(nuevoIdioma)) {
//			AGREGAR EL IDIOMA QUE VIENE POR PARAMETRO A LA LISTA DE IDIOMAS QUE SABE LA PERSONA
			this.agregarIdioma(nuevoIdioma);
		}

	}

	public boolean existeIdioma(IIdioma idioma) {
		boolean existe = false;
		for (int i = 0; !existe && i < masIdiomas.length; i++) {
			IIdioma aux = masIdiomas[i];
			existe = aux.getClass().equals(idioma.getClass());
		}
		return existe;
	}

	public void agregarIdioma(IIdioma idioma) {
		IIdioma[] nuevaLista = new IIdioma[this.masIdiomas.length + 1];
		for (int i = 0; i < this.masIdiomas.length; i++) {
			nuevaLista[i] = this.masIdiomas[i];
		}
		nuevaLista[this.masIdiomas.length] = idioma;
		this.masIdiomas = nuevaLista;
	}

	public void decir(String algo) {
		if (algo != null) {
			this.idiomaNativo.decir(algo);
		}

	}

	public void decir(String algo, IIdioma unIdioma) {
//		PRIMERO DEBO SABER SI LA PERSONA HABLA ESE IDIOMA 
//		RECORRO LA LISTA DE IDIOMAS O ME FIJO SI NACIO CON ESE IDIOMA 
		IIdioma aux = null;
		if (!esMismoIdioma(this.idiomaNativo, unIdioma)) {
//			VERIFICA SI ES ALGUNO DE LOS OTROS QUE SABE HABLAR
			for (int i = 0; aux == null && i < this.masIdiomas.length; i++) {
				if (esMismoIdioma(this.masIdiomas[i], unIdioma)) {
					aux = unIdioma;
				}
			}
		} else {
			aux = this.idiomaNativo;
		}

		if (aux != null) {
//				ENCONTRO EL IDIOMA 
			unIdioma.decir(algo);
		} else {
			System.out.println(this.nombre + " no habla " + unIdioma.getClass().getCanonicalName());
		}
	}

	private boolean esMismoIdioma(IIdioma source, IIdioma target) {
		return source.getClass().equals(target.getClass());
	}
	
	public void decirEnTodos(String algo) {
		this.decir(algo);
		
		if (algo != null) {
			for(IIdioma idioma : masIdiomas) {
				idioma.decir(algo);
			}
			
		}
	}
}
