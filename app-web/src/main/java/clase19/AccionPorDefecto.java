package clase19;

public class AccionPorDefecto implements IAccion {

	@Override
	public void exec(Context ctx) {	
		System.out.println(ctx+" ACCION POR DEFECTO");
	}

}
