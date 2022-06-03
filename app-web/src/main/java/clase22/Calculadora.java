package clase22;

public class Calculadora {

	public static int dividir(int a, int b) throws DivisionException {
		if (b == 0) {
			throw new DivisionException("El parametro b es 0, no se puede dividir por 0");
		}
		return a / b;
	}
}
