package ar.com.educacionit.services;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.exceptions.ServiceException;

public interface ArticuloService {

	/**
	 * OBTINEE UN ARTICULO DADO SU ID= PK
	 * @return
	 * @throws ServiceException 
	 */
	
	public Articulo getById(Long id) throws ServiceException;
}
