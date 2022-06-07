package ar.com.educacionit.daos;

import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

public interface ArticuloDao {

	public Articulo save(Articulo articulo);
	public Articulo getByPK(Long pk) throws GenericException;
	public Articulo update(Articulo articuloToUpdate);
	public Articulo delete(Long pk);
}
