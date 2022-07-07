package ar.com.educacionit.web.controllers;

import java.util.Scanner;

import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.daos.impl.ArticuloDaoMysqlImpl;
import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticuloService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticuloServiceImpl;

public class InsertArticulo {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Ingrese los datos del articulo: ");
//		LEER LOS DATOS DEL ARTICULO
		System.out.println("Precio:");
		Double precio = teclado.nextDouble();
		System.out.println("titulo: ");
		String titulo = teclado.next();
		System.out.println("Codigo:");
		String codigo = teclado.next();
		System.out.println("Stock:");
		Long stock = teclado.nextLong();
		System.out.println("Marcas:");
		Long marcaId = teclado.nextLong();
		System.out.println("Categoria:");
		Long categoriaId = teclado.nextLong();

		teclado.close();
		Articulo nuevo = new Articulo(titulo, codigo, null, precio, stock, marcaId, categoriaId);

//		INSERTARLO 
//		PUEDO HACERLO PERO NO DEBO 
		ArticuloDao artDao = new ArticuloDaoMysqlImpl();

		ArticuloService articuloService = new ArticuloServiceImpl();

		try {
			articuloService.save(nuevo);
		} catch (ServiceException e) {
			System.err.println(e.getMessage() + "," + e.getCause().getMessage());
		} catch (DuplicatedException e) {
			System.err.println(e.getMessage() + "," + e.getCause().getMessage());
			System.out.println("Existe, actualizando...");
//			SI FUE DUPLICADO
			try {
				Articulo artQueExisteEnLaDB = articuloService.getByCodigo(nuevo.getCodigo());

//				ACTUALIZO LOS DATOS DE ART CON LOS DE NUEVO 
				artQueExisteEnLaDB.setCategoriasId(nuevo.getCategoriasId());
				artQueExisteEnLaDB.setMarcasId(nuevo.getMarcasId());
				artQueExisteEnLaDB.setPrecio(nuevo.getPrecio());
				artQueExisteEnLaDB.setTitulo(nuevo.getTitulo());
				artQueExisteEnLaDB.setStock(nuevo.getStock());

				articuloService.update(artQueExisteEnLaDB);
			} catch (ServiceException e1) {
				System.err.println(e1.getMessage() + "," + e1.getCause().getMessage());
			}
		}
		
	}
}
