package ar.com.educacionit.daos.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.daos.SocioDao;
import ar.com.educacionit.domain.Socios;

public class SocioDaoMySqlImpl extends JDBCBaseDao<Socios> implements SocioDao {

	public SocioDaoMySqlImpl() {
		super("socios");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Socios fromResultSetToEntity(ResultSet rs) throws SQLException {
		Long id = rs.getLong("id");
		String apellido = rs.getString("apellido");
		String nombre = rs.getString("nombre");
		String codigo = rs.getString("codigo");
		return new Socios(id, nombre, apellido, codigo);
	}

	@Override
	public String getSaveSQL() {
		return "(apellido, nombre, codigo) VALUES (?,?,?)";
	}
	
	@Override
	public void saveData(Socios entity, PreparedStatement st) throws SQLException {
		st.setString(1, entity.getApellido());
		st.setString(2, entity.getNombre());
		st.setString(1, entity.getCodigo());
	}
}
