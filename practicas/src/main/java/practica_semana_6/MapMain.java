package practica_semana_6;

public class MapMain {

	public static void main(String[] args) {

		IAccion<AccionAlta> alta = new AccionAlta();
		
		try {
			alta.save(null);
			alta.update(null);
			alta.delete(null);
			alta.getById(null);
		} catch (SaveException | DeleteException |UpdateException | GetByIdException e) {
			e.printStackTrace();
		}
		
		
	}

}
