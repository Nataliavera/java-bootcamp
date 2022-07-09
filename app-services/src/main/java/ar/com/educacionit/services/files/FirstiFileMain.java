package ar.com.educacionit.services.files;

import java.io.File;
import java.io.IOException;

public class FirstiFileMain {

	public static void main(String[] args) throws IOException {
		
//		crear un object de la clase file 
		
		File archivo = new File("c:/desarrollo/text.txt");
		
		boolean exists = archivo.exists();//verificar si existe el archivo
		
		if(!exists) {
			archivo.createNewFile();//crear un archivo
		}
		exists = archivo.exists();
		System.out.println(exists);
		
		boolean isFile =archivo.isFile();//es archivo
		boolean isDirec =archivo.isDirectory();//es directorio
		
		System.out.println(isFile);
		System.out.println(isDirec);
		
//		recursividad 
		
		
		
	}

	/*
	 * recursividad
	 * REALIZAR LA SUMA DE N
	 * 5+4+3+2+1
	 * 
	 * */
	public static int sumar(int n) {
		int suma = 0; 
		while(n > 0) {
			suma += n; 
			n --;
		}
		return suma;
	}
}
