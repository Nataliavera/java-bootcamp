package clase13;

public class MainFormulario {

	public static void main(String[] args) {

//		opcion de formulario 
		int op = 1; //1= LEGALES , 2 = CONTRATO

		Formulario f= FormularioBuilder.crearFormulario(op);
		
		String textoFinal = f.compilarEtiquetas();
		
		System.out.println(textoFinal);
		
	}

}
