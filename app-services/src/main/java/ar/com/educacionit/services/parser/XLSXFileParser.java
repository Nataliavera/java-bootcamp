package ar.com.educacionit.services.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ar.com.educacionit.services.exceptions.ParseException;

public class XLSXFileParser extends FileBase implements IParser<Collection<Producto>> {

	public XLSXFileParser(String filePath) {
		super(filePath);
	}

	@Override
	public Collection<Producto> parse() throws ParseException {
		Collection<Producto> list = new ArrayList<>();
//		workbook -> representa todo el documento 
//		row -> fila de una hoja en particula 
//		sheet 
//		cell

		File file = super.getFile();

		try (InputStream is = new FileInputStream(file); Workbook workbook = new XSSFWorkbook(is);) {

			Sheet hoja1 = workbook.getSheetAt(0);// pedimos una hoja

//			recorro cada una de las filas 
			Iterator<Row> rows = hoja1.iterator();

			boolean isFirstRow = true;

			Row row = rows.next();

			while (rows.hasNext()) {
				row = rows.next();

				Iterator<Cell> itCells = row.cellIterator();

//				capturar el valor de la celda 
				while (itCells.hasNext()) {
					Producto p = productoFromCell(itCells);
					list.add(p);

				}
			}

			return list;
		} catch (IOException e) {
			e.printStackTrace();
			throw new ParseException("No se ha podido convertir el archivo: " + file.getPath(), e);
		}
	}

	private Producto productoFromCell(Iterator<Cell> itCells) {
		
		Producto p = new Producto();
		
		while (itCells.hasNext()) {
			Cell cell = itCells.next();
			switch (cell.getColumnIndex()) {
			case 0://id
				p.setId(Long.parseLong(cell.getStringCellValue()));
				break;
			case 1://nombre
				p.setTitle(cell.getStringCellValue());
				break;
			case 2://code
				p.setCode(cell.getStringCellValue());
				break;
			case 3://precio
				p.setPrice(Double.parseDouble(cell.getStringCellValue()));
				break;
			default:
				
				break;
			}
		}
		return p;
	}

}
