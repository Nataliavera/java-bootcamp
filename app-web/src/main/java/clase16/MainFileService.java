package clase16;

import clase16.service.FileService;
import clase16.service.FileServiceBuilder;

public class MainFileService {

	public static void main(String[] args) {

		String archivo = "nota.csv";
		
		String contenidoArchivo = "nombre; apellido;nota";
		
		FileServiceBuilder fsb = new FileServiceBuilder(archivo);
		
		FileService service = fsb.buildService(contenidoArchivo);
		
		service.save();
		
		service.validar();
		
//		service.parse();
		
	}

}
