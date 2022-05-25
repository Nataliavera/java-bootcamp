package clase17;

import java.util.LinkedList;

public class LinkedlistMain {
// SECUENCIAL, PERO NO ENLAZADA 
//	CON MUCHOS ELEMENTOS ES MUY LENTO > PARA VELOCIDAD SE UTILIZA UN ARRAYLIST 
	public static void main(String[] args) {

		LinkedList<String> nombres = new LinkedList<>();
		
		nombres.add("carlos");
		nombres.add("juan");
		nombres.add("jose");
		nombres.add("maria");
		nombres.add("brian");
		
		nombres.iterator();
		
//		AGREGAR ELEMENTOS AL PRINCIPIO
		nombres.addFirst("natalia");
		
//		AGREGAR ELEMENTOS AL FINAL 
		nombres.addLast("andres");
		
//		RECORRER EL LINKEDLIST
		for(String nombre : nombres) {
			System.out.println(nombre);
		}
	}

}
