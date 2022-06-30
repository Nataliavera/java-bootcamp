package ar.com.educacioit.daos;

import java.util.List;

import ar.com.educacionit.daos.CategoriasDao;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.daos.impl.CategoriaDaoMysqlImpl;
import ar.com.educacionit.domain.Categorias;

public class CategoriasDaoMySqlImplTestCase {

	public static void main(String[] args) throws GenericException {

		//test when_findall_then_showlist
		
		CategoriasDao dao = new CategoriaDaoMysqlImpl();
		
		List<Categorias> list = dao.findAll();
		
		System.out.println(list.size() > 0);
		
	}

}
