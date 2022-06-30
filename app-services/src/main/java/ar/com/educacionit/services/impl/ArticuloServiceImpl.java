package ar.com.educacionit.services.impl;

import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.daos.impl.ArticuloDaoMysqlImpl;
import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticuloService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class ArticuloServiceImpl extends AbstractBaseService<Articulo> implements ArticuloService {

	public ArticuloServiceImpl() {
		super(new ArticuloDaoMysqlImpl());
	}

	@Override
	public Articulo getByCodigo(String codigo) throws ServiceException {
		try {
			return ((ArticuloDaoMysqlImpl)dao).getByCodigo(codigo);
		} catch (GenericException e) {
			throw new ServiceException("Error al consultar T", e);
		}
	}

}
