package ar.com.educacionit.services;

import java.util.List;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticuloServiceImpl;

public class ArticuloServiceImplTestCase {

	public static void main(String[] args) throws ServiceException {
		
		ArticuloService service = new ArticuloServiceImpl();
		
		List<Articulo> list =service.findAll();
		
		System.out.println(list.size() > 0);
	}
}