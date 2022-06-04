package practica_semana_6;

public interface IAccion<T> {

	public void save(Context ctx) throws SaveException;

	public void update(Context ctx) throws UpdateException;

	public void delete(String id) throws DeleteException;
	
	public String getById(String id) throws GetByIdException;
}
