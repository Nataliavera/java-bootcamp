package ar.com.educacionit.daos.db;

public class MainTryWithResources {

	public static void main(String[] args) {
// 	QUE SE PUEDEN "AUTOCERRAR"
		
//		CLASE DEBE IMPLEMENTAR UNA INTERFACE AUTO/CLOUSEABLE
		ConexionDB con = new ConexionDB("root", "1234");
		
		if(con.isOpen()) {
//			CONSULTAR ALGUN DATO DE LA DB Ñ
		}
		
	}

}
