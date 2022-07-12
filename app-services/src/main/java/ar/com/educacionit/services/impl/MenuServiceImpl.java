package ar.com.educacionit.services.impl;

import ar.com.educacionit.daos.GenericDao;
import ar.com.educacionit.daos.impl.MenuDaoImpl;
import ar.com.educacionit.domain.Menu;
import ar.com.educacionit.services.MenuService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class MenuServiceImpl extends AbstractBaseService<Menu> implements MenuService {

	public MenuServiceImpl() {
		super(new MenuDaoImpl());
	}

	@Override
	public Menu getByCodigo(String codigo) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
