package ar.com.educacionit.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.daos.MenuDao;
import ar.com.educacionit.domain.Menu;

public class MenuDaoImpl extends JDBCBaseDao<Menu> implements MenuDao {

	public MenuDaoImpl() {
		super("menu");
	}

	@Override
	public Menu fromResultSetToEntity(ResultSet rs) throws SQLException {
		Long id = rs.getLong("id");
		String texto = rs.getString("texto");
		Long root = rs.getLong("root");
		Long idMenuPadre = rs.getLong("id_menu_padre");

		return new Menu(id,texto, root.equals(1L), idMenuPadre);
	}

}
