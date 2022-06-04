package practica_semana_6;

public class AccionAlta implements IAccion<AccionAlta> {

	@Override
	public void save(Context ctx) throws SaveException {
		DBMemory.save(ctx.getId(), ctx.getEdad(), ctx.getMonto().toString());
	}

	@Override
	public void update(Context ctx) throws UpdateException {
		DBMemory.update(ctx.getEdad(), ctx.getMonto().toString());
	}

	@Override
	public void delete(String id) throws DeleteException {
		DBMemory.delete(id);
	}

	@Override
	public String getById(String id) throws GetByIdException {
		String res = DBMemory.getById(id);
		return res;
	}

	


}
