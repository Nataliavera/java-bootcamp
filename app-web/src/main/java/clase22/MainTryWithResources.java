package clase22;

import java.util.Scanner;

public class MainTryWithResources {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		SE CIERRA AUTOMATICAMENTE 
		try (Scanner teclado = new Scanner(System.in)){
			System.out.println(teclado);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
