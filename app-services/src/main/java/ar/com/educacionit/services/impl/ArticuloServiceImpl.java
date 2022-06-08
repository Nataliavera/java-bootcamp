package ar.com.educacionit.services.impl;

import java.util.List;

import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.daos.impl.ArticuloDaoMysqlImpl;
import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticuloService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class ArticuloServiceImpl implements ArticuloService {

//	PUEDE TENER UNA INSTANCIA DE ALGUN DAO -> NECESITAMOS EL DE ARTICULO

	private ArticuloDao dao;

	public ArticuloServiceImpl() {
//		DEPENDE DE LA DB
//		String motorDB = System.getenv("TIPO_MOTOR");
		this.dao = new ArticuloDaoMysqlImpl();

	}

	@Override
	public Articulo getById(Long id) throws ServiceException {
		try {
			return dao.getByPK(id);
		} catch (GenericException e) {
			throw new ServiceException("Error al consultar articulo", e);
		}
	}

	@Override
	public void delete(Long id) throws ServiceException {
		try {
			dao.delete(id);
		} catch (GenericException e) {
			throw new ServiceException("Error al eliminar articulo", e);
		}
		
	}

	@Override
	public void update(Articulo entity) throws ServiceException {
		try {
			dao.update(entity);
		} catch (GenericException e) {
			throw new ServiceException("Error al actualizar articulo", e);
		}
		
	}

	@Override
	public List<Articulo> obtenerTodos() throws ServiceException {
		try {
			return dao.findAll();
		} catch (GenericException e) {
			throw new ServiceException("Error al consultar los articulos", e);
		}
	}

}
