package ar.com.educacionit.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.daos.GenericDao;
import ar.com.educacionit.daos.db.AdministradorDeConexiones;
import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Entity;

public abstract class JDBCBaseDao<T extends Entity> implements GenericDao<T> {
// T extends Entity -> CORTAR LA TRANSFERENCIA DE CAPA EN CAPA

	protected String tabla;

	public JDBCBaseDao(String tabla) {
		if (tabla == null) {
			throw new IllegalArgumentException("Debe indicar la tabla del DAO");
		}
		this.tabla = tabla;
	}

//	cada impl debe especificar como es su sql insert
	public abstract String getSaveSQL();

	public abstract void saveData(T entity, PreparedStatement pst) throws SQLException;

	public void save(T entity) throws DuplicatedException, GenericException {
//		INSER INTO this.tabla (columnas) values (valores) > sql particular de cada entity
		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {

			StringBuffer sql = new StringBuffer("INSERT INTO ").append(this.tabla).append(this.getSaveSQL());
			try (PreparedStatement st = con2.prepareStatement(sql.toString(),
					PreparedStatement.RETURN_GENERATED_KEYS)) {

				this.saveData(entity, st);

				st.execute(); // alt +shift + m
				try (ResultSet rs = st.getGeneratedKeys()) {
					if (rs.next()) {
						Long id = rs.getLong(1);
						entity.setId(id);
					}
				}
			}
		} catch (SQLException se) {
			if (se instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("No se ha podido insertar el articulo, integridad de datos violada", se);
			}
			throw new GenericException(se.getMessage(), se);
		} catch (GenericException e) {
			throw new GenericException(e.getMessage(), e);
		}

	}
	
	public abstract String getUpdateSQL(T entity);
	public abstract void updateData(T entity, PreparedStatement st) throws SQLException;

	public void update(T entity) throws GenericException {
		
		String sql = "UPDATE " + this.tabla + " SET " +this.getUpdateSQL(entity) + " WHERE ID=?";
		
		//contar cuantos ?
		int idx = getWhereIndex(sql);

		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {

			try (PreparedStatement st = con2.prepareStatement(sql.toString())) {

				// puedo setear atributo=valor con el tipo correcto
				
				this.updateData(entity, st);

				st.setLong(idx, entity.getId());

				st.execute();// alt+shift+m
			}
		} catch (GenericException ge) {
			throw new GenericException(ge.getMessage(), ge);
		} catch (SQLException se) {
			throw new GenericException(se.getMessage(), se);
		}
	}

	/*
	 * Determina el indice del where en un update
	 */
	private int getWhereIndex(String sql) {
		int idx = 0;
		for(char c : sql.toString().toCharArray()) {
			if(c == '?') {
				idx ++;
			}
		}
		return idx;
	}

	@Override
	public T getByPK(Long id) throws GenericException {
//		connection 
		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
			try (Statement st = con.createStatement()) {

				String sql = "SELECT * FROM " + this.tabla + " WHERE ID =" + id;

				try (ResultSet rs = st.executeQuery(sql)) {
					T entity = null;

					if (rs.next()) {
						entity = fromResultSetToEntity(rs);
					}
					return entity;
				}
			}
		} catch (SQLException e) {
			throw new GenericException("No se pudo obtener el entity " + this.tabla + " id: " + id, e);
		}
	}

	// CADAD HIJO CONVIERTE EL RESULTSET A LA ENTIDAD QUE LE CORRESPONDE
	public abstract T fromResultSetToEntity(ResultSet rs) throws SQLException;

	@Override
	public List<T> findAll() throws GenericException {
		List<T> registros = new ArrayList<T>();
		String sql = "SELECT * FROM " + this.tabla;
		try (Connection con = AdministradorDeConexiones.obtenerConexion();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {
			while (rs.next()) {
				T entity = this.fromResultSetToEntity(rs);
				registros.add(entity);
			}
		} catch (SQLException e) {
			throw new GenericException("No se pudieron obtener los entity " + this.tabla + " id: ", e);
		}
		return registros;
	}

	@Override
	public void delete(Long id) throws GenericException {
//		SQL ELIMINAR UN REGISTRO 
		String sql = "DELETE FROM " + this.tabla + " WHERE ID = " + id;
		try (Connection con2 = AdministradorDeConexiones.obtenerConexion(); Statement st = con2.createStatement();) {
			st.executeUpdate(sql);
		} catch (GenericException e) {
			throw new GenericException(sql, e);
		} catch (SQLException se) {
			throw new GenericException(sql, se);
		}
	}

	// PAGINADO
	@Override
	public List<T> findPageable(Integer currentPage, Integer size) throws GenericException {
		List<T> registros = new ArrayList<T>();
		String sql = "SELECT * FROM " + this.tabla + " LIMIT " + size + " OFFSET " + (currentPage - 1);
		try (Connection con = AdministradorDeConexiones.obtenerConexion();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {
			while (rs.next()) {
				T entity = this.fromResultSetToEntity(rs);
				registros.add(entity);
			}
		} catch (SQLException e) {
			throw new GenericException("No se pudieron obtener los entity " + this.tabla + " id: ", e);
		}
		return registros;
	}
}
