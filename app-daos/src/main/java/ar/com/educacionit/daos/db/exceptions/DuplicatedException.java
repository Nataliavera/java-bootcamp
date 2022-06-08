package ar.com.educacionit.daos.db.exceptions;

public class DuplicatedException extends Exception {

	public DuplicatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicatedException(String message) {
		super(message);
	}

	
}
