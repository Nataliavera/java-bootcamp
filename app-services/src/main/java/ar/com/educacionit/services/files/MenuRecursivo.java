package ar.com.educacionit.services.files;

import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.domain.Menu;

public class MenuRecursivo {

	public static void main(String[] args) {

		List<Menu> menus = getMenuFromDB();

//		RECORRER EL MENU DE MANERA RECURSIVA

		mostrarMenu(menus);

	}

	private static void mostrarMenu(List<Menu> menus) {
//		caso base 
		for (Menu m : menus) {
			System.out.println(m.getTexto());
			if (m.isRoot()) {
				System.out.println("------------------------");
			}
			if(!m.getSubMenu().isEmpty()) {
				mostrarMenu(m.getSubMenu());// recursividad
			}
		}
	}

	private static List<Menu> getMenuFromDB() {
		List<Menu> subMenu = new ArrayList<>();
		Menu nhtml = new Menu("HTML", new ArrayList<>(), false);
		subMenu.add(nhtml);

		Menu references = new Menu("References", subMenu, true);
		
		Menu hijosGuides = new Menu("H1", new ArrayList<>(), false);
		List<Menu> submenuHG = new ArrayList<>();
		submenuHG.add(hijosGuides);
		
		subMenu = new ArrayList<>();
		Menu mdn = new Menu("MDN", submenuHG, false);
		subMenu.add(mdn);

		Menu guides = new Menu("Guides", subMenu, true);

		List<Menu> menus = new ArrayList<>();
		menus.add(references);
		menus.add(guides);

		return menus;
	}

}
