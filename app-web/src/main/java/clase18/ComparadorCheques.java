package clase18;

public class ComparadorCheques extends ChequeComparator {

	@Override
	public int comparar(Cheque c1, Cheque c2) {
// 		FECHA DE PAGO 
//		BANCO 
//		CMC7
		int resta = 0;
		if(c1.getFechaPago() == null || c2.getFechaPago() == null) {
			resta = 0; 
		}
		c1.getFechaPago().compareTo(c2.getFechaPago());
		
//		COMPARO POR BANCO 
		if(resta == 0) {
			resta = c1.getBanco().compareTo(c2.getBanco());
		}
		
//		SI COINCIDEN LOS BANCOS COMPARO CMC7
		if(resta == 0) {
			resta = c1.getCmc7().compareTo(c2.getCmc7());
		}
		
		return resta;
	}

}
