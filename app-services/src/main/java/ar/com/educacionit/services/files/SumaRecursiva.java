package ar.com.educacionit.services.files;

public class SumaRecursiva {

	public static void main(String[] args) {
		int suma = 0; 
		
		int n = 5; 
//		5+4+3+2+1
		while(n >0) {
			suma += n; 
			n--;
		}
		
		System.out.println("Suma sin recursividad: s"+suma);
		
		int sum = suma(10);
		
		System.out.println("Suma recursiva: "+sum);
		
		int fac = factorial(5);
		
		System.out.println("Factorial:"+fac);
		
		System.err.println(esPalindromo("m"));
		System.out.println(esPalindromo("jose"));
		System.out.println(esPalindromo("neuquen"));
		
	}
//	un caso base: donde se termina la recursividad 
//	Recursividad -> un metodo que se invoca a si mismo
	
	public static int suma(int n) {
//		identificar el caso base 
		if(n >0) {
			return n + suma(n-1);
		}
		return n; 
	}
	
	
	/**
	 * calcular el factorial de un numero 
	 * */
	public static int factorial(int n) {
		if(n != 0 && n !=1) {
			return n * factorial(n - 1);
		}
		return n;
	}
	
	
	/**
	 * 
	 * */
	public static boolean esPalindromo(String palabra) {
		if(palabra.length() <=1) {
			return true; 
		}else {
//		cadena[0] con cadena[cadena.length()-1]
			if(palabra.charAt(0) == palabra.charAt(palabra.length()-1)) {
				return esPalindromo(palabra.substring(1,palabra.length()-1)); 
			}else {
				return false;
			}
		}
		
		
	}
}
