package ar.com.educacionit.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.daos.db.AdministradorDeConexiones;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

public class ArticuloDaoMysqlImpl implements ArticuloDao {

//	private Connection con;

	public ArticuloDaoMysqlImpl() {
//		try {
//			this.con = AdministradorDeConexiones.obtenerConexion();
//		} catch (GenericException e) {
//			throw new IllegalArgumentException(e.getMessage(), e);
//		}
	}

	@Override
	public Articulo save(Articulo articulo) {

		return articulo;
	}

	@Override
	public Articulo getByPK(Long id) throws GenericException {
//		connection 
		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
//		statement 
			try (Statement st = con.createStatement()) {

//			EXECUTE DEL SQL 
//		resultset
//			EXECUTEQUERY -> SOLO ES PARA HACER CONSULTAS DE SELECT 
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
			}
		} catch (SQLException e) {
			throw new GenericException("No se pudo obtener el articulo id: " + id, e);
		}

	}

	@Override
	public void update(Articulo articuloToUpdate) throws GenericException {
		StringBuffer sql = new StringBuffer("UPDATE ARTICULOS SET ");
//		ACTUALIZO SI EL DATO VIENE INFORMADO
		if (articuloToUpdate.getTitulo() != null) {
			sql.append("TITULO=?").append(",");
		}
		if (articuloToUpdate.getCodigo() != null) {
			sql.append("CODIGO=?").append(",");
		}
		if (articuloToUpdate.getPrecio() != null) {
			sql.append("PRECIO=?").append(",");
		}
		if (articuloToUpdate.getStock() != null) {
			sql.append("STOCK=?").append(",");
		}
		if (articuloToUpdate.getMarcasId() != null) {
			sql.append("MARCA_ID=?").append(",");
		}
		if (articuloToUpdate.getCategoriasId() != null) {
			sql.append("CATEGORIA_ID=?").append(",");
		}

		sql = new StringBuffer(sql.substring(0, sql.length() - 1));

		sql.append(" WHERE ID=?");

		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {

			try (PreparedStatement st = con2.prepareStatement(sql.toString())) {
//				PUEDO SETETAR ATRIBUTO = VALOR DEL TIPO CORRECTO 

				if (articuloToUpdate.getTitulo() != null) {
					st.setString(1, articuloToUpdate.getTitulo());
				}
				if (articuloToUpdate.getCodigo() != null) {
					st.setString(2, articuloToUpdate.getCodigo());
				}
				if (articuloToUpdate.getPrecio() != null) {
					st.setDouble(3, articuloToUpdate.getPrecio());
				}
				if (articuloToUpdate.getStock() != null) {
					st.setLong(4, articuloToUpdate.getStock());
				}
				if (articuloToUpdate.getMarcasId() != null) {
					st.setLong(5, articuloToUpdate.getMarcasId());
				}
				if (articuloToUpdate.getCategoriasId() != null) {
					st.setLong(6, articuloToUpdate.getCategoriasId());
				}
				st.setLong(7, articuloToUpdate.getId());
				st.execute(); // alt +shift + m
			}
		} catch (GenericException e) {
			throw new GenericException(e.getMessage(), e);
		} catch (SQLException se) {
			throw new GenericException(se.getMessage(), se);
		}

	}

	@Override
	public void delete(Long id) throws GenericException {
//		SQL ELIMINAR UN REGISTRO 
		String sql = "DELETE FROM ARTICULOS WHERE ID = " + id;

//		1 ABRO CONEXION 
//		2 ABRIR UN STATEMENT 

		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {

//		AUTO COMMIT EN FALSE
//			con2.setAutoCommit(false);
			try (Statement st = con2.createStatement()) {
				st.executeUpdate(sql);
			}
//			con2.commit();
		} catch (GenericException e) {
//			con2.rollback();
			throw new GenericException(sql, e);
		} catch (SQLException se) {
//			con2.rollback();
			throw new GenericException(sql, se);
		}

	}

	@Override
	public List<Articulo> findAll() throws GenericException {

		List<Articulo> registros = new ArrayList<Articulo>();
		String sql = "SELECT * FROM ARTICULOS";
		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
			try (Statement st = con.createStatement()) {
				try (ResultSet rs = st.executeQuery(sql)) {
					while (rs.next()) {
						Articulo articulo = fromResultSetToEntity(rs);
						registros.add(articulo);
					}
				}
			}
		} catch (SQLException e) {
			throw new GenericException("No se pudieron obtener los articulos id: ", e);
		}
		return registros;
	}

	private Articulo fromResultSetToEntity(ResultSet rs) throws SQLException {
		Long idArticulo = rs.getLong("ID");
		String titulo = rs.getString("TITULO");
		String codigo = rs.getString("CODIGO");
		Date fechaCreacion = rs.getDate("FECHA_CREACION");
		Double precio = rs.getDouble("PRECIO");
		Long stock = rs.getLong("STOCK");
		Long marcasId = rs.getLong("MARCA_ID");
		Long categoriasId = rs.getLong("CATEGORIA_ID");

		return new Articulo(idArticulo, titulo, codigo, fechaCreacion, precio, stock, marcasId, categoriasId);
	}

}
