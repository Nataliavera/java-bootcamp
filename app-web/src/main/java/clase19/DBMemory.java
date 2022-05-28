package clase19;

import java.util.HashMap;
import java.util.Map;

public class DBMemory {

	static private Map<String, String> db = new HashMap<String, String>();
	
	public static void save(String key, String valor) {
//	CARGAR LOS DATOS EN LA DB			
		DBMemory.db.put(key, valor);
	}
	
	public static void update(String key, String newValue) {
		DBMemory.db.replace(key, newValue);
	}
	
	public static void delete(String key) {
	DBMemory.db.remove(key);	
	}
	
	public static String getById(String key) {
		String value = null; 
		if(DBMemory.db.containsKey(key)) {
			value = DBMemory.db.get(key);
		}
		return value;
	}
}
