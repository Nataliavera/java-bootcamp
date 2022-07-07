package ar.com.educacionit.daos.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.daos.CategoriasDao;
import ar.com.educacionit.domain.Categorias;

public class CategoriaDaoMysqlImpl extends JDBCBaseDao<Categorias> implements CategoriasDao {

	public CategoriaDaoMysqlImpl() {
		super("categorias");
	}

	public Categorias fromResultSetToEntity(ResultSet rs) throws SQLException {
		Long idCategoria = rs.getLong("ID");
		String descripcion = rs.getString("DESCRIPCION");
		Long habilitada = rs.getLong("HABILITADA");

		return new Categorias(idCategoria, descripcion, habilitada);
	}

	@Override
	public String getSaveSQL() {
		return "(DESCRIPCION, HABILITADA) VALUES(?,?)";
	}

	@Override
	public void saveData(Categorias entity, PreparedStatement st) throws SQLException {
		st.setString(1, entity.getDescripcion());
		st.setLong(2, entity.getHabilitada());
	}

	@Override
	public String getUpdateSQL(Categorias entity) {
		StringBuffer sql = new StringBuffer();
		if (entity.getDescripcion() != null) {
			sql.append("DESCRIPCION=?").append(",");
		}
		if (entity.getHabilitada() != null) {
			sql.append("HABILITADA=?").append(",");
		}
		return sql.substring(0, sql.length() - 1).toString();
	}

	@Override
	public void updateData(Categorias entity, PreparedStatement st) throws SQLException {
		if (entity.getDescripcion() != null) {
			st.setString(1, entity.getDescripcion());
		}
		if (entity.getHabilitada() != null) {
			st.setLong(2, entity.getHabilitada());
		}
	}

}
