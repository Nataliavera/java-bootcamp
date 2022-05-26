package clase18;

import java.util.Comparator;

public abstract class FechaPagoComparator implements Comparator<Cheque>{

	@Override
	public int compare(Cheque c1, Cheque c2) {
		int resta ;
		if(c1  == null || c2 == null) {
			resta = 0;
		}
		
		if(c1 == c2) {
			resta = 0; 
		}
		
//		COMPARAR POR FECHA DESC
		if(c1.getFechaPago() == null || c2.getFechaPago() == null) {
			resta = 0; 
		}else {
			resta =  this.comparar(c1, c2);
		}
		
		return resta; 
	}

	public abstract int comparar(Cheque c1, Cheque c2);
	
}
