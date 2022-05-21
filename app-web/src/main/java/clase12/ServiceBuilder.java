package clase12;

public class ServiceBuilder {

	public final static IService buildService(String site) {
		
//		INTERFACE I = NEW CLASEQUEIMPLEMENTALAINTERFACE()
		IService service;
		switch (site) {
		case "1":
			service = new ServiceS1();
			break;
		case "2":
			service = new ServiceS2();
		default:
			service = new DefaultService();
			break;
		}
		return service;
	}
	
}
