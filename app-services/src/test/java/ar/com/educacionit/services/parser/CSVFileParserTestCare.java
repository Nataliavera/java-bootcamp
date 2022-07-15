package ar.com.educacionit.services.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collection;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import ar.com.educacionit.services.exceptions.ParseException;

public class CSVFileParserTestCare {

	@Test
	@Order(1)
	public void when_nullfilename_then_throw_exception() {
//		null
		assertThrows(IllegalArgumentException.class, () -> {
			new CSVFileParser(null);
		});
	}
	
	@Test
	public void when_blankfilename_then_throw_exception() {
//		""
		assertThrows(IllegalArgumentException.class, () -> {
			new CSVFileParser("");
		});
	}
	
	@Test
	public void when_doesnotexists_file_then_parseit() {
		assertThrows(ParseException.class, () -> {
			new CSVFileParser("c:/bla/bla").parse();
		});
	}
	
//	que haya una instancia valida 
	@Test
	public void when_create_doesexists() {
		assertNotNull(new CSVFileParser("c:/bla/bla"));
	}
	
	@Test
	public void when_fileexists_then_verify_size() throws ParseException {
		CSVFileParser parser = new CSVFileParser("C:\\desarrollo");
		Collection<Producto> list = parser.parse();
		assertEquals(2, list.size());
	}
	
	@Test
	public void when_xlsxfileexists_then_verify_size() throws ParseException {
		XLSXFileParser parser = new XLSXFileParser("C:\\desarrollo\\Libro1.xlsx");
		Collection<Producto> list = parser.parse();
		assertEquals(2, list.size());
	}
	
	
}
