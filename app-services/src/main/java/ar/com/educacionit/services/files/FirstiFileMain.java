package ar.com.educacionit.services.files;

import java.io.File;
import java.io.IOException;

public class FirstiFileMain {

	public static void main(String[] args) throws IOException {

//		crear un object de la clase file 

		File archivo = new File("c:/desarrollo/text.txt");

		boolean exists = archivo.exists();// verificar si existe el archivo

		if (!exists) {
			archivo.createNewFile();// crear un archivo
		}
		exists = archivo.exists();
		System.out.println(exists);

		boolean isFile = archivo.isFile();// es archivo
		boolean isDirec = archivo.isDirectory();// es directorio

		System.out.println(isFile);
		System.out.println(isDirec);

		if (isDirec) {
//			DEVUELVE UN ARRAY DE LOS NOMBRES DE LOS ARCHIVOS QUE HAY EN EL DIRECTORIO
			String[] filesNames = archivo.list();
			for (String fileName : filesNames) {
				System.out.println(fileName);
			}
		} else {
			System.out.println(archivo.getName());
		}

		/*
		 * buscar el archivo: xx dentro de un directorio y sus subcarpetas
		 * 
		 * si se encuentra mostrar la carpeta que lo contiene, de lo contrario informar
		 * que no existe
		 */

		String name = "";//nombre del archivo a buscar

		File archivo2 = new File("c:/desarrollo");//ruta donde se encuentra la carpeta

		if (archivo2.exists()) {
			File arname = buscarFile(archivo2, name);
			if (arname != null) {
				System.out.println("Se ha encontrado el archivo " + name + " en la carpeta " + arname.getPath());
			}else {
				System.out.println("No se ha encontrado el archivo " + name);
			}
		}

	}

	public static File buscarFile(File folder, String name) {
//		CASO BASE 
		if (folder.isDirectory() || folder.list().length > 0) {
			System.out.println("Carpeta: "+folder.getName());
			File aux = null;
			File[] filesInFiles = folder.listFiles();// arrays
			
			for(int i = 0; i< filesInFiles.length; i++) {
				File aFile = filesInFiles[i];
				aux = buscarFile(aFile, name);
			}
			/*
			for (File aFile : filesInFiles) {
				aux = buscarFile(aFile, name);
				if (aux != null) {
					return aux;
				}
			}*/
			return aux;
		} else {
			System.out.println("Archivo: "+folder.getName());
			File aux = null;
			if (folder.getName().equalsIgnoreCase(name)) {	//nombre coincide o no
				aux = folder;
			}
			return aux;
		}
	}

	/*
	 * recursividad REALIZAR LA SUMA DE N 5+4+3+2+1
	 * 
	 */
	public static int sumar(int n) {
		int suma = 0;
		while (n > 0) {
			suma += n;
			n--;
		}
		return suma;
	}
}
