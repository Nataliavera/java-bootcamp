package ar.com.educacionit.web;

import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.daos.OrdenDao;
import ar.com.educacionit.daos.SocioDao;
import ar.com.educacionit.daos.impl.ArticuloDaoMysqlImpl;
import ar.com.educacionit.daos.impl.OrdenDaoImpl;
import ar.com.educacionit.daos.impl.SocioDaoImpl;
import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.domain.Orden;
import ar.com.educacionit.domain.Socio;

public class MainConexionDBTest {

	public static void main(String[] args) {

//		DAO > IMPL
		OrdenDao dao = new OrdenDaoImpl();
		
//		CREAR LA ORDEN 
		Orden o = new Orden(1L, "test", 150f);
		
		dao.create(o);
		
		ArticuloDao daoAr = new ArticuloDaoMysqlImpl();
//		Articulo ar = new Articulo(null, null, null); 
		
//		daoAr.create(ar);
		
		SocioDao daoSo = new SocioDaoImpl();
		Socio so = new Socio(null, null, null, null);
	}

}
