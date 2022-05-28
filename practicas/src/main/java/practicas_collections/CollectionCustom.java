package practicas_collections;

import java.util.Comparator;

public class CollectionCustom implements Comparator<Equipos>{

	@Override
	public int compare(Equipos e1, Equipos e2) {
		if(e1.getPuntaje()>e2.getPuntaje()) {
			return 1;
		}else if(e1.getPuntaje()<e2.getPuntaje()) {
			return -1;
		}else {
			return 0;
		}
	}

	


	
}
