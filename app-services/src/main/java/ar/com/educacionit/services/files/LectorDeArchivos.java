package ar.com.educacionit.services.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.SociosServiceImpl;

public class LectorDeArchivos {

	public static void main(String[] args) throws IOException {
//PARA LEER UN ARCHIVO BINARIO SE NECESITA DE UNA LIBRERIA
		
		String path = "C:\\desarrollo/text.txt";
		File file = new File(path);
		
		if(file.exists()) {
//			leer el archivo 
			List<Socios> socios = leerArchivo(file);
			
			if(!socios.isEmpty()) {
//				grabo los datos
				SociosService ss = new SociosServiceImpl();
				
				for(Socios s : socios) {
					try {
						ss.create(s);
					} catch (ServiceException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private static List<Socios> leerArchivo(File file) throws IOException {
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		
		String linea = null;
		
//		leo la primer linea y la descarto porque representa las columnas 
		linea = br.readLine();
		
		List<Socios> sociosList = new ArrayList<>();
		while((linea = br.readLine()) != null) {
//			System.out.println(linea)
			Socios socio = sociosFromString(linea);
			sociosList.add(socio);
		}
		br.close();
		
		return sociosList;
	}

	private static Socios sociosFromString(String linea) {
		
		String[] datos = linea.split(";");//buscar la informacion y la separa por el ;
		String apellido = datos[0];
		String nombre = datos[1];
		String codigo = datos[2];
		
		return new Socios(nombre, apellido, codigo);
		
		
	}

	
}
