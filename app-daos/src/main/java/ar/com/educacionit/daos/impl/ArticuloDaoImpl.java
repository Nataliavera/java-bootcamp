package ar.com.educacionit.daos.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.daos.db.AdministradorDeConexiones;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

public class ArticuloDaoImpl implements ArticuloDao {

	private Connection con;

	public ArticuloDaoImpl() {
		try {
			this.con = AdministradorDeConexiones.obtenerConexion();
		} catch (GenericException e) {
			throw new IllegalArgumentException(e.getMessage(), e);
		}
	}

	@Override
	public Articulo save(Articulo articulo) {

		return articulo;
	}

	@Override
	public Articulo getByPK(Long id) throws GenericException {
//		connection 

//		statement 
		try (Statement st = this.con.createStatement()) {

//			EXECUTE DEL SQL 
//		resultset
			try (ResultSet rs = st.executeQuery("SELECT * FROM ARTICULOS WHERE ID =" + id)) {
				Articulo articulo = null;
//			EXTRAER LOS DATOS QUE VIENEN EN EL RS 
				if (rs.next()) {
					Long idArticulo = rs.getLong("ID");
					String titulo = rs.getString("TITULO");
					String codigo = rs.getString("CODIGO");
					Date fechaCreacion = rs.getDate("FECHA_CREACION");
					Double precio = rs.getDouble("PRECIO");
					Long stock = rs.getLong("STOCK");
					Long marcasId = rs.getLong("MARCA_ID");
					Long categoriasId = rs.getLong("CATEGORIA_ID");

					articulo = new Articulo(idArticulo, titulo, codigo, fechaCreacion, precio, stock, marcasId,
							categoriasId);

//		convertir el resultset a articulo
				}
				return articulo;
			}
		} catch (SQLException e) {
			throw new GenericException("No se pudo obtener el articulo id: " + id, e);
		}

	}

	@Override
	public Articulo update(Articulo articuloToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articulo delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
