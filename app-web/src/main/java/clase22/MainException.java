package clase22;

import java.util.Scanner;

public class MainException {

	public static void main(String[] args) {

//		int a = 10;
//		int b = 0; 
//		int c = a/b; 
//		
//		System.out.println(c);
//		
//		Venta v1 = null; 
//		System.out.println(v1.getFecha());
		
		int a = 100; 
		int b = 0;
		boolean error= true; 
		Scanner teclado = new Scanner(System.in);
		do {
			try {
				b = teclado.nextInt();
				error = false; 
			}catch(Exception e){
//				LIMIPIAR EL TECLADO 
				teclado.next();
				continue;
			}
		}while(error);
		
		try {
			int div = Calculadora.dividir(a, b);
			System.out.println(div);
		} catch (DivisionException e) {
			e.printStackTrace();
		}finally {
//			LO QUE SIEMPRE QUIERO QUE SE EJECUTE 
			teclado.close();
		}
	}

}
