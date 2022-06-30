package ar.com.educacionit.services;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.exceptions.ServiceException;

public interface ArticuloService  extends GenericService<Articulo>{

	public Articulo getByCodigo(String codigo) throws ServiceException;
}
