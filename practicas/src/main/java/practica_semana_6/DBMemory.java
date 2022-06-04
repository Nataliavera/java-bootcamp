package practica_semana_6;

import java.util.HashMap;
import java.util.Map;

public class DBMemory implements AutoCloseable {

	static private Map<String, String> db = new HashMap<String, String>();

	public static void save(String key, String valor, String monto) throws SaveException {
//	CARGAR LOS DATOS EN LA DB			
		DBMemory.db.put(key, valor);
	}

	public static void update(String key, String newValue) throws UpdateException {
		DBMemory.db.replace(key, newValue);
	}

	public static void delete(String key) throws DeleteException {
		DBMemory.db.remove(key);
	}

	public static String getById(String key) throws GetByIdException {
		String value = null;
		if (DBMemory.db.containsKey(key)) {
			value = DBMemory.db.get(key); 
		}
		return value;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
