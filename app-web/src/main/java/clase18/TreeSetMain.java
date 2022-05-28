package clase18;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;



public class TreeSetMain {

	public static void main(String[] args) {

//		LIST> ADMITEN DUPLICADOS 
//		SET > NO ADMITEN DUPLICADOS 

		Collection<String> nombres = new TreeSet<String>();

		nombres.add("jose");
		nombres.add("jose");

//		LOS TIPOS WRAPPER DE JAVA IMPLEMENTAN LA INTERFAZA COMPARABLE 
		System.out.println(nombres);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1986);
		cal.set(Calendar.MONTH, 2);
		cal.set(Calendar.DATE, 10);
		
		Cheque c1 = new Cheque("1002000", "rio", cal.getTime());// ROOT
		
		cal.add(Calendar.DATE, 1);// +1 dia
		Cheque c2 = new Cheque("1002001", "bbva", cal.getTime());// DER
		
		cal.add(Calendar.DATE, 1);
		Cheque c3 = new Cheque("1000000", "patagonia", cal.getTime());// IZQ
		
		cal.add(Calendar.DATE, 1);
		Cheque c4 = new Cheque("1002000", "patagonia", cal.getTime());// IZQ

//		AGREGO UN ORDEN EXTERNO A LA COLLECTION
		Comparator<Cheque> cmp = new ComparadorCheques();// FUNCIONA PORQUE CHEQUE IMPLEMETA COMPARATOR
		
		
		Collection<Cheque> cheques = new TreeSet<Cheque>(new FechaPagoAsc());
		cheques.add(c1);
		cheques.add(c2);
		cheques.add(c3);
		cheques.add(c4);

//		RECORRER 
		Iterator<Cheque> itCheque = cheques.iterator();
		while (itCheque.hasNext()) {
			Cheque unCheque = itCheque.next();
			System.out.println(unCheque);
		}

//		ELIMINAR 
		while (itCheque.hasNext()) {
			Cheque unCheque = itCheque.next();
			itCheque.remove();
		}

		System.out.println(cheques.isEmpty());

		
		
		

		
	}

}
