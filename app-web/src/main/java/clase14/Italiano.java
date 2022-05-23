package clase14;

public class Italiano implements IIdioma {

	@Override
	public void decir(String algo) {
		System.out.println("Ciao, parlo in italiano "+algo);
	}

}
