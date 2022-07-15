package ar.com.educacionit.services.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ar.com.educacionit.services.exceptions.ParseException;

public class CSVFileParser implements IParser<Collection<Producto>> {

	private String filePath;

//	path del archivo
	public CSVFileParser(String filePath) {
		if (filePath == null || "".equals(filePath)) {
//			lanzo una RuntimeException
			throw new IllegalArgumentException("Debe indicar el path del archivo");
		}
		this.filePath = filePath;
	}

	@Override
	public Collection<Producto> parse() throws ParseException {

		File file = this.getFile();

		try {
			return this.readFile(file);

		} catch (IOException e) {
			e.printStackTrace();
			throw new ParseException("Error leyendo el archivo:" + file.getName(), e);
		}
	}

	private File getFile() throws ParseException {
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

	private static List<Producto> readFile(File file) throws IOException {
		FileReader fr = new FileReader(file);

		BufferedReader br = new BufferedReader(fr);

		String line = null;

//		leo la primer linea y la descarto porque representa las columnas 
		line = br.readLine();

		List<Producto> list = new ArrayList<>();
		while ((line = br.readLine()) != null) {
//			System.out.println(linea)
			Producto producto = rowFromString(line);
			list.add(producto);
		}
		br.close();

		return list;
	}

	private static Producto rowFromString(String linea) {

		String[] rowData = linea.split(";");// buscar la informacion y la separa por el ;
		Long id = (Long.parseLong(rowData[0]));
		String title = rowData[1];
		String code = rowData[2];
		Double price = (Double.parseDouble(rowData[3]));

		return new Producto(id, title, code, price);

	}

}
