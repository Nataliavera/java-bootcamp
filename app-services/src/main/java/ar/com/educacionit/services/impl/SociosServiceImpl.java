package ar.com.educacionit.services.impl;

import ar.com.educacionit.daos.impl.SocioDaoMySqlImpl;
import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class SociosServiceImpl extends AbstractBaseService<Socios> implements SociosService {

	public SociosServiceImpl() {
		super(new SocioDaoMySqlImpl());
	}

	@Override
	public Socios getByCodigo(String codigo) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
