package ar.com.educacionit.daos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ar.com.educacionit.daos.db.exceptions.GenericException;

public class AdministradorDeConexiones {

//	STATIC PARA NO TENER QUE INSTANCIAR LA CLASE 
	public static Connection obtenerConexion() throws GenericException {
		String host = "localhost";
		String user = "root";
		String password = "root";
		String port = "";
		String dbName = "bootcamp-java-educacionit";

		String driverName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://" + host + "/" + dbName + "?serverTimeZone=UTC&userSSL=false";
//		CREACION DE LA CLASE QUE PERTENECE AL JAR DE MYSQL-CONNECTOR 
//		NO PUEDO HACER UN NEW DRIVER, CARGAR DINAMICAMENTE UNA CLASE USANDO: 

		try {
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException sqe) {
			throw new GenericException("No se ha podido conectar a:" + url, sqe);
		} catch (ClassNotFoundException cnfe) {
			throw new GenericException("No se ha encontrado el driver: " + driverName, cnfe);
		}

	}
}
