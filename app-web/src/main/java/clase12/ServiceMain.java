package clase12;

import java.util.Iterator;

public class ServiceMain {

	public static void main(String[] args) {

		String sitio = "1";
		
//		CREO MI SERVICIO CON BASE AL SITIO
		IService service = ServiceBuilder.buildService(sitio);
		
		Dato dato = service.consultar();
		
		
		Formateable formateador = new FormatoPDF(dato);
		
		formateador.formatear();
		
		Formateable fh = new FormatoHTML(dato);
		
		fh.formatear();
		
		dato.detalle();
	}

}
