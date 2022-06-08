package ar.com.educacionit.services;

import java.util.List;

import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.exceptions.ServiceException;

public interface ArticuloService {

	/**
	 * OBTINEE UN ARTICULO DADO SU ID= PK
	 * @return
	 * @throws ServiceException 
	 */
	
	public Articulo getById(Long id) throws ServiceException;
	
	public Articulo getByCodigo(String codigo) throws ServiceException;
	
	public void delete(Long id) throws ServiceException;
	
	public void update(Articulo entity) throws ServiceException;

	public List<Articulo> obtenerTodos() throws ServiceException;

	public void save(Articulo entity) throws ServiceException, DuplicatedException;
}
