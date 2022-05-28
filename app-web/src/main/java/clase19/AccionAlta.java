package clase19;

public class AccionAlta implements IAccion {

	@Override
	public void exec(Context ctx) {	
//		ctx.getTeclado();
//		USA LA BASE DE DATOS EN MEMORIA 
		DBMemory.save(ctx.getId(), ctx.getEdad().toString());
	}

}
