package ar.com.educacionit.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import ar.com.educacionit.daos.CategoriasDao;
import ar.com.educacionit.daos.db.AdministradorDeConexiones;
import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Categorias;

public class CategoriaDaoMysqlImpl extends JDBCBaseDao<Categorias> implements CategoriasDao {

	public CategoriaDaoMysqlImpl() {
		super("categorias");
	}

	@Override
	public void save(Categorias Categoria) throws DuplicatedException, GenericException {

		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {

			StringBuffer sql = new StringBuffer("INSERT INTO Categorias (DESCRIPCION, HABILITADA VALUES(");
			sql.append("?,?)");

			try (PreparedStatement st = con2.prepareStatement(sql.toString(),
					PreparedStatement.RETURN_GENERATED_KEYS)) {
//				
				st.setString(1, Categoria.getDescripcion());
				st.setLong(2, Categoria.getHabilitada());
				st.execute(); // alt +shift + m
				try (ResultSet rs = st.getGeneratedKeys()) {
					if (rs.next()) {
						Long id = rs.getLong(1);

						Categoria.setId(id);
					}
				}
			}
		} catch (SQLException se) {
			if (se instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("No se ha podido insertar el Categoria, integridad de datos violada", se);
			}
			throw new GenericException(se.getMessage(), se);
		} catch (GenericException e) {
			throw new GenericException(e.getMessage(), e);
		}

	}

	@Override
	public void update(Categorias CategoriaToUpdate) throws GenericException {
		StringBuffer sql = new StringBuffer("UPDATE CategoriaS SET ");
//		ACTUALIZO SI EL DATO VIENE INFORMADO
		if (CategoriaToUpdate.getDescripcion() != null) {
			sql.append("TITULO=?").append(",");
		}
		if (CategoriaToUpdate.getHabilitada() != null) {
			sql.append("CODIGO=?").append(",");
		}

		sql = new StringBuffer(sql.substring(0, sql.length() - 1));

		sql.append(" WHERE ID=?");

		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {

			try (PreparedStatement st = con2.prepareStatement(sql.toString())) {
//				PUEDO SETETAR ATRIBUTO = VALOR DEL TIPO CORRECTO 

				if (CategoriaToUpdate.getDescripcion() != null) {
					st.setString(1, CategoriaToUpdate.getDescripcion());
				}
				if (CategoriaToUpdate.getHabilitada() != null) {
					st.setLong(2, CategoriaToUpdate.getHabilitada());
				}
				st.setLong(7, CategoriaToUpdate.getId());
				st.execute(); // alt +shift + m
			}
		} catch (GenericException e) {
			throw new GenericException(e.getMessage(), e);
		} catch (SQLException se) {
			throw new GenericException(se.getMessage(), se);
		}

	}

	public Categorias fromResultSetToEntity(ResultSet rs) throws SQLException {
		Long idCategoria = rs.getLong("ID");
		String descripcion = rs.getString("DESCRIPCION");
		Long habilitada = rs.getLong("HABILITADA");

		return new Categorias(idCategoria, descripcion, habilitada);
	}

}
