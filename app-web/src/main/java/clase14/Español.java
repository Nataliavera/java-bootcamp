package clase14;

public class Español implements IIdioma {

	@Override
	public void decir(String algo) {
		System.out.println("Hola, estoy hablando en español "+algo);
	}

}
