package ar.com.educacionit.daos;

import java.util.List;

import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

public interface ArticuloDao {

	public List<Articulo> findAll() throws GenericException;
	public void save(Articulo articulo) throws GenericException, DuplicatedException;
	public Articulo getByPK(Long pk) throws GenericException;
	public void update(Articulo articuloToUpdate) throws GenericException;
	public void delete(Long pk) throws GenericException;
	
//	NO FORMA PARTE DEL CRUD
	public Articulo getByCodigo(String codigo) throws GenericException;
}
