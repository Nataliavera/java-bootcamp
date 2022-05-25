package clase17;

import java.util.ArrayList;
import java.util.List;

public class Carrito implements IDatos<String>{

//	ITEMS 
	private List<String> items; 
	
	public Carrito() {
		items = new ArrayList<String>();
	}
	
	public void agregar(String item) {
		items.add(item);
	}
}
