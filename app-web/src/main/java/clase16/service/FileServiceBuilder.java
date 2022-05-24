package clase16.service;

import clase16.service.impl.CSVFServiceParser;
import clase16.service.impl.PDFFServiceParser;
import clase16.service.impl.XLSFServiceParser;

public class FileServiceBuilder {

	private String archivo;

//	CONSTRUSTOR DETERMINA EL ARCHIVO
	public FileServiceBuilder(String archivo) {
//		PUEDO AGREGAR VALIDACIONES EN LA CONSTRUCCION DEL OBJETO 
		if(archivo == null) {
//			LANZAR ERROR
			this.archivo = archivo;
		}else {
			archivo = "";
		}
	}

//	BUILDER DETERMINA EL CONTENIDO 
	public FileService buildService(String fileContent) {
//		LOGICA -> DADO EL NOMBRE DETERMINAR QUE TIPO DE ARCHIVO ES 
		String[] nombreArr = archivo.split("\\.");
//		nombreArr[0] nombre
//		nombre[1] extension

//		OTRA MANERA DE HACERLO
//		int idx = archivo.lastIndexOf(".");//DEVUELVE UN INT 
//		String ext = archivo.substring(idx+1, archivo.length());

		FileService fs = null;
		switch (nombreArr[1]) {
		case "csv":
			fs = new CSVFServiceParser(fileContent);
			break;
		case "xlsx":
			fs = new XLSFServiceParser(fileContent);
			break;
		case "pdf":
			fs = new PDFFServiceParser(fileContent);
			break;
//			AGREGO UN NUEVO CASE 
		default:
			fs = null;
			break;
		}

		return fs;
	}

}
