package ar.com.educacionit.web.controllers;

import java.util.Scanner;

import ar.com.educacionit.services.ArticuloService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticuloServiceImpl;

public class DeleteArticuloController {

	public static void main(String[] args) {

		ArticuloService service = new ArticuloServiceImpl();
		
		Scanner teclado  = new Scanner(System.in);
		
		System.out.println("Ingrese Id del articulo: ");
		Long id = teclado.nextLong();
		
		try {
			service.delete(id);
			System.out.println("Se ha eliminado correctamente");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		
		teclado.close();
	}

}
