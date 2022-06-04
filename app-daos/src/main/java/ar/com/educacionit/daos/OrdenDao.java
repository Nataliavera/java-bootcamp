package ar.com.educacionit.daos;

import ar.com.educacionit.domain.Orden;

/**
 * QUE ES UN DAO? 
 * DATA ACCESS OBJECT -> OBJECTO DE ACCESO A DATOS 
 * 
 * ME PERMITE DEFINIR CIERTOS METODOS QUE PERMITEN MODIFICAR UNA ENTIDAD EN ALGUN ENTORNO 
 * PWRMITE HACER UN CRUD SOBRE UNA ENTIDAD
 * CREATE, READ, UPDATE, DELETE 
 * 
 * @author ASUS VIVOBOOK
 *
 */

public interface OrdenDao {

//	DEFINIR LOS METODOS CRUD
	
	public Orden create(Orden orden);
	public Orden read(Long id);
	public Orden update(Orden ordenToUpdate);
	public Orden delete(Long id);
	
	 
}
