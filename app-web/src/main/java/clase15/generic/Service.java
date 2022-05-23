package clase15.generic;

public abstract class Service<T> {

	protected IGenericOperacion<T> iTabla;
	
	public Service(IGenericOperacion<T> tabla) {
		this.iTabla = tabla;
	}
}
