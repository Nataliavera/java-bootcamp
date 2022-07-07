package ar.com.educacionit.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.daos.db.AdministradorDeConexiones;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

public class ArticuloDaoMysqlImpl extends JDBCBaseDao<Articulo> implements ArticuloDao {

	public ArticuloDaoMysqlImpl() {
		super("articulos");
	}

	@Override
	public String getSaveSQL() {
		return "(TITULO, CODIGO, FECHA_CREACION, PRECIO, STOCK, MARCA_ID, CATEGORIA_ID) VALUES (?,?,?,?,?,?,?)";
	}

	@Override
	public void saveData(Articulo entity, PreparedStatement pst) throws SQLException {
		pst.setString(1, entity.getTitulo());
		pst.setString(2, entity.getCodigo());
		pst.setDate(3, new java.sql.Date(System.currentTimeMillis()));// java.sql.Date
		pst.setDouble(4, entity.getPrecio());
		pst.setLong(5, entity.getStock());
		pst.setLong(6, entity.getMarcasId());
		pst.setLong(7, entity.getCategoriasId());
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

	public Articulo fromResultSetToEntity(ResultSet rs) throws SQLException {
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

	@Override
	public Articulo getByCodigo(String codigo) throws GenericException {
		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
			String sql = "SELECT * FROM ARTICULOS WHERE CODIGO =?";
			try (PreparedStatement st = con.prepareStatement(sql)) {

				st.setString(1, codigo);

				try (ResultSet rs = st.executeQuery()) {
					Articulo articulo = null;
					if (rs.next()) {
						Long idArticulo = rs.getLong("ID");
						String titulo = rs.getString("TITULO");
						String codigo2 = rs.getString("CODIGO");
						Date fechaCreacion = rs.getDate("FECHA_CREACION");
						Double precio = rs.getDouble("PRECIO");
						Long stock = rs.getLong("STOCK");
						Long marcasId = rs.getLong("MARCA_ID");
						Long categoriasId = rs.getLong("CATEGORIA_ID");

						articulo = new Articulo(idArticulo, titulo, codigo2, fechaCreacion, precio, stock, marcasId,
								categoriasId);

					}
					return articulo;
				}
			}
		} catch (SQLException e) {
			throw new GenericException("No se pudo obtener el articulo codigo: " + codigo, e);
		}
	}

	@Override
	public void updateData(Articulo entity, PreparedStatement st) throws SQLException {
		if (entity.getTitulo() != null) {
			st.setString(1, entity.getTitulo());
		}
		if (entity.getCodigo() != null) {
			st.setString(2, entity.getCodigo());
		}
		if (entity.getPrecio() != null) {
			st.setDouble(3, entity.getPrecio());
		}
		if (entity.getStock() != null) {
			st.setLong(4, entity.getStock());
		}
		if (entity.getMarcasId() != null) {
			st.setLong(5, entity.getMarcasId());
		}
		if (entity.getCategoriasId() != null) {
			st.setLong(6, entity.getCategoriasId());
		}

	}

	@Override
	public String getUpdateSQL(Articulo entity) {
		StringBuffer sql = new StringBuffer();

		if (entity.getTitulo() != null) {
			sql.append("TITULO=?").append(", ");
		}
		if (entity.getCodigo() != null) {
			sql.append("CODIGO=?").append(", ");
		}
		if (entity.getPrecio() != null) {
			sql.append("PRECIO=?").append(", ");
		}
		if (entity.getStock() != null) {
			sql.append("STOCK=?").append(", ");
		}
		if (entity.getMarcasId() != null) {
			sql.append("MARCA_ID?").append(", ");
		}
		if (entity.getCategoriasId() != null) {
			sql.append("CATEGORIA_ID=?").append(",");
		}

		return sql.substring(0, sql.length() - 1).toString();
	}

}
