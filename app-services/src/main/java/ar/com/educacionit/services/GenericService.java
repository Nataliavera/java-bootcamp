package ar.com.educacionit.services;

import java.util.List;

import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.services.exceptions.ServiceException;

public interface GenericService<T> {

	/**
	 * OBTINEE UN T DADO SU ID= PK
	 * @return
	 * @throws ServiceException 
	 */
	
	public T getById(Long id) throws ServiceException;
	
	public T getByCodigo(String codigo) throws ServiceException;
	
	public void delete(Long id) throws ServiceException;
	
	public void update(T entity) throws ServiceException;

	public List<T> findAll() throws ServiceException;

	public void save(T entity) throws ServiceException, DuplicatedException;
	
	public void create(T nuevo) throws ServiceException;
}
