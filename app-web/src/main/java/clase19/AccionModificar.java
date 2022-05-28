package clase19;

public class AccionModificar implements IAccion {

	@Override
	public void exec(Context ctx) {
		System.out.println(ctx+" ACCION MODIFICAR");
		
		DBMemory.update(ctx.getId(), ctx.getId());

	}

}
