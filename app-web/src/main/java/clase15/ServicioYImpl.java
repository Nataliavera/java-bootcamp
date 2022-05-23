package clase15;

public class ServicioYImpl implements IGeneric<TipoY> {

	@Override
	public TipoY parse() {
		String datos = "{}";

		TipoY ty = new TipoY(datos);

		return ty;
	}

}
