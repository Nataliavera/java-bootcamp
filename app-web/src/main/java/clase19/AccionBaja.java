package clase19;

public class AccionBaja implements IAccion {

	@Override
	public void exec(Context ctx) {
		
		String id = ctx.getId();
		
		this.baja(id);		
		
		System.out.println(ctx+" ACCION BAJA");
		
		DBMemory.delete(ctx.getId());

	}

	private void baja(String id) {
		// TODO Auto-generated method stub
		
	}

}
