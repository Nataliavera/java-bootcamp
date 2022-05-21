package ejercicio;

public class TorreMain {
  
	public static void main(String[] args) {
		
//		SIMULAR LA CREACION DE LOS OBJETOS 
		Volador[] voladores = CreadorDeVoladores.crearVoladores();
		
//		ANALIZAR SI PUEDEN ATERRIZAR SI PUEDEN ATERRIZAR EN LA PISTA 
		for(Volador v: voladores) {
//			CUMPLE O NO 
			if(v instanceof Aterrizable) {
				Aterrizable a = (Aterrizable)v;
				Estado estado = a.aterrizar();
				
				if(estado.isError()) {
					System.out.println(v.getNombre()+" : "+estado.getMsj()+" enviar ayuda");
				}
			}else {
				System.out.println("No puede aterrizar..."+v);
			}
		}
	}
}
