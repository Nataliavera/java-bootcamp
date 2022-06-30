package ar.com.educacionit.daos;

import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

public interface ArticuloDao extends GenericDao<Articulo> {

//	NO FORMA PARTE DEL CRUD
	public Articulo getByCodigo(String codigo) throws GenericException;
}
