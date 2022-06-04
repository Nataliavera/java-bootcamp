package ar.com.educacionit.daos;

import ar.com.educacionit.domain.Articulo;

public interface ArticuloDao {

	public Articulo create(Articulo articulo);
	public Articulo read(Long id);
	public Articulo update(Articulo articuloToUpdate);
	public Articulo delete(Long id);
}
