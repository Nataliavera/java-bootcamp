package ar.com.educacionit.services.impl;

import ar.com.educacionit.daos.impl.CategoriaDaoMysqlImpl;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class CategoriaServiceImpl extends AbstractBaseService<Categorias> implements CategoriaService {

	public CategoriaServiceImpl() {
		super(new CategoriaDaoMysqlImpl());
	}

	@Override
	public Categorias getByCodigo(String codigo) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
