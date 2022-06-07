package ar.com.educacionit.daos.db.exceptions;

import java.sql.SQLException;

public class GenericException extends Exception {

	public GenericException(String msj, Exception sqe) {
		super(msj,sqe);
	}

}
