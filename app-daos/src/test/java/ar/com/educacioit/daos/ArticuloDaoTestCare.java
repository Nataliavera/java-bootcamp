package ar.com.educacioit.daos;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.daos.impl.ArticuloDaoMysqlImpl;
import ar.com.educacionit.domain.Articulo;

@TestMethodOrder(OrderAnnotation.class)
public class ArticuloDaoTestCare {

	@Order(1)
	@Test // NECESARIO PARA PODER HACER EL TEST
	public void then_initialize_then_showIt() {
		ArticuloDao art = new ArticuloDaoMysqlImpl();
		assertNotNull(art);
	}

//	PRUEBA DE PERSISTENCIA 
	@Order(2)
//	@Test
	@Ignore // para que no se ejecute o simplemente no coloco el @Test
	public void when_newArticulo_then_persistIt() throws GenericException, DuplicatedException {
//		QUIERO PROBAR EL METODO SAVE 
		ArticuloDao art = new ArticuloDaoMysqlImpl();

//		NECESITO UN ARTICULO
		Articulo newArticulo = new Articulo("titulo", "codigo", new java.util.Date(), 1500d, 10l, 1l, 1l);

		art.save(newArticulo);

//		como verifico que hay un articulo nuevo en la DB -> con el ID
		assertNotNull(newArticulo.getId());
	}

	@Order(3)
	@Test
	public void when_findAllArticulo_then_listIt() throws GenericException, DuplicatedException {
		ArticuloDao art = new ArticuloDaoMysqlImpl();

		List<Articulo> arts = art.findAll();

		assertNotEquals(0, arts.size());
		assertEquals(7, arts.size());
	}

	@Order(4)
	@Test
	public void when_getOneByCode_then_showIt() throws GenericException {
		ArticuloDao artDap = new ArticuloDaoMysqlImpl();

		Articulo art = artDap.getByCodigo("2222");

		assertEquals("2222", art.getCodigo());
	}

	@Order(5)
	@Test
	public void when_exists_then_updateIt() throws GenericException {
		ArticuloDao artDap = new ArticuloDaoMysqlImpl();

		Articulo art = artDap.getByCodigo("00123");

		art.setTitulo("nuevo titulo");
		art.setCodigo("001222");

		artDap.update(art);

		assertEquals("nuevo titulo", art.getTitulo());
	}

	@Order(4)
	@Test
	public void when_create_update_delete_then_notExist() throws GenericException, DuplicatedException {
		ArticuloDao artDap = new ArticuloDaoMysqlImpl();

//		CREAR
		Articulo newArticulo = new Articulo("titulo", "codigo", new java.util.Date(), 1500d, 10l, 1l, 1l);
		artDap.save(newArticulo);

		Long id = newArticulo.getId();
		assertNotNull(id);

//		UPDATE
		newArticulo = artDap.getByCodigo("00123");

		newArticulo.setTitulo("nuevo titulo");
		newArticulo.setCodigo("001222");

		artDap.update(newArticulo);

//		 delete
		artDap.delete(id);
	}

	@Test
	public void when_duplicate_then_throw_exception() throws GenericException, DuplicatedException {
		//quiero probar el metodo save
		ArticuloDao art = new ArticuloDaoMysqlImpl();
		
		//necesito un articulo
		Articulo newArticulo = new Articulo("titulo", "codigo1001", new java.util.Date(), 1500d, 100l, 1l, 1l);
		
		art.save(newArticulo);
		
//		assertThrows(DuplicatedException.class, () -> {
//			newArticulo.setCodigo("codigo1002");
//			art.save(newArticulo);			
//		});
		
	}
}
