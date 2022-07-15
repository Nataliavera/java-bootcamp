package ar.com.educacionit.services.parser;

import ar.com.educacionit.services.exceptions.ParseException;

public interface IParser<T> {

	//CONVERTIR UN TIPO DETERMINADO
	public T parse() throws ParseException;
}
