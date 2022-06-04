package practica_collection;

import java.util.Arrays;

public class CollectionCustom<T> {

	private T[] lista; 
	
	public CollectionCustom(T[] tamanio) {
		this.lista = tamanio;
	}
	
	public int size() {
		int size = lista.length;
		return size;
	}
	
	public void addFirst(T item) {
		T[] nuevaLista = Arrays.copyOf(lista, (lista.length +1));
		
		nuevaLista[0] = item;
		for (int i = 0; i < lista.length; i++) {
			nuevaLista[i+1] = lista[i];
		}
	}
	
	public void addLast(T item) {
		T[] nuevaLista = Arrays.copyOf(lista, (lista.length +1));
		nuevaLista[nuevaLista.length - 1] = item;
		lista = nuevaLista;
	}
	
	public void add(T item) {
		lista[lista.length] = item;
	}
	
	public T[] remove(T item) {
		T[] nuevaLista = null;
		for (int i = 0; i < lista.length; i++) {
			if(lista[i] == item) {
				nuevaLista = Arrays.copyOf(lista, (lista.length -1));
				for (int index = 0; index < i; index++) {
					nuevaLista[index] = lista[index];
				}
				for (int j = 0; j < lista.length; j++) {
					nuevaLista[j] = lista[j];
				}
			}
		}
		return nuevaLista;
	}
	
	public void removeAll() {
		for (int i = 0; i < lista.length; i++) {
			lista[i] = null;
		}
	}
	
	public boolean empty() {
		boolean vacio = false;
		if(lista.length == 0) {
			vacio = true;
		}else {
			vacio = false;
		}
		return vacio;
	}
	
}
