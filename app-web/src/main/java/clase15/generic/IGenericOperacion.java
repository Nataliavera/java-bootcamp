package clase15.generic;

public interface IGenericOperacion<T> {
	
	public T crear(); 
	public void eliminar(); 
	public T buscarPorID(Long id); 
}
