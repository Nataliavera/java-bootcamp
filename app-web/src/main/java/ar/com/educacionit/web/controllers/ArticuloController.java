package ar.com.educacionit.web.controllers;

import java.util.List;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticuloService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticuloServiceImpl;

public class ArticuloController {

	public static void main(String[] args) {

		ArticuloService service = new ArticuloServiceImpl();
		
//		TODO IMPLEMENTAR UN MENU DE ACCIONES 
		try {
			List<Articulo> list = service.findAll();
			
			/*if(!list.isEmpty()) {
				Articulo articulo = service.getById(list.get(0).getId());
				
				System.out.println(articulo);
				
//			AHORA ELIMINO EL ARTICULO 
//			service.delete(articulo.getId());
				
//			System.out.println("Se ha eliminado "+articulo.getId());
				articulo.setStock(25L);
				articulo.setPrecio(2500d);
				
				service.update(articulo);
				
			}*/
			
//			MOSTRAR TODOS LOS ARTICULOS DE LA BASE DE DATOS 
			System.out.println(list);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
