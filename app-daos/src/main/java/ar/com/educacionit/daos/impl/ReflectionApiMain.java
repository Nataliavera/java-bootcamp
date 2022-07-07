package ar.com.educacionit.daos.impl;

import java.lang.reflect.Field;
import java.util.Date;

import ar.com.educacionit.domain.Articulo;

public class ReflectionApiMain {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

		Articulo art = new Articulo(1l, "titulo", "codig", new Date(), 1500d, 1l, 1l, 1l);
		
		mostrarAtributos(art);
	
	}

	private static void mostrarAtributos(Object obj) throws IllegalAccessException{
		//COMO SE CUANTOS ATRIBUTOS TIENE? 
		Class clazz = obj.getClass();
		
		Field[] arts = obj.getClass().getDeclaredFields();
		
		for(Field f : arts) {
			f.setAccessible(true);
			System.out.print(f.getName());
			//System.out.println(f.getModifiers());
			Object valor = f.get(obj);
			System.out.println(valor);
		}
		
		
	}
}
