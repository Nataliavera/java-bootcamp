package ar.com.educacionit.services.parser;

import java.io.File;

import ar.com.educacionit.services.exceptions.ParseException;

public abstract class FileBase {

	protected String filePath;

//	path del archivo
	public FileBase(String filePath) {
		if (filePath == null || "".equals(filePath)) {
//			lanzo una RuntimeException
			throw new IllegalArgumentException("Debe indicar el path del archivo");
		}
		this.filePath = filePath;
	}
	
	protected File getFile() throws ParseException {
		File file = new File(this.getFilePath());

		if (!file.exists()) {
			throw new ParseException("No existe el archivo: " + file.getAbsolutePath());
		} // alt+shift+m
		return file;
	}
	
	private String getFilePath() {
//		ACA PUEDO AGREGAR LOGICA PARA EL PATH
		return filePath;
	}
}
