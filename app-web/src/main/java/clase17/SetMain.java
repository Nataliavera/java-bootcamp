package clase17;

import java.util.HashSet;
import java.util.Set;

public class SetMain {

	public static void main(String[] args) {
		Set<Carrito> carrito = new HashSet<Carrito>();
		
		Carrito c = new Carrito();
		carrito.add(c);
		
		Carrito c2 = new Carrito();
		carrito.add(c2);
		
//		SON DOS INSTANCIAS DISTINTAS
		System.out.println(c.equals(c2));
		
		System.out.println(carrito.contains(c));
		System.out.println(carrito.contains(c2));
	}
}
