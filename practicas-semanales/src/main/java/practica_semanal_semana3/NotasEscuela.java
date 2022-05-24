package practica_semanal_semana3;

import java.util.Iterator;
import java.util.Scanner;

public class NotasEscuela {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		String apyn[];
		double notas[][];
		int tEstudiantes, tNotas;
		double suma[], mayor, menor;
		double promedio[];

//		CANTIDAD DE ESTUDIANTES Y NOTAS
		System.out.println("Ingrese el número de estudiantes: ");
		tEstudiantes = teclado.nextInt();

		System.out.println("Ingrese el número de notas por estudiante: ");
		tNotas = teclado.nextInt();

//		INICIALIZACION DE VARIABLES
		apyn = new String[tEstudiantes];
		notas = new double[tEstudiantes][tNotas];
		promedio = new double[tEstudiantes];
		suma = new double[tNotas];

//		RELLENO DE VECTORES Y MATRICES
		for (int i = 0; i < tEstudiantes; i++) {
			System.out.println("Digite el nombre y el apellido del estudiante: ");
			apyn[i] = teclado.next();

			for (int j = 0; j < tNotas; j++) {
				System.out.println("Digite las notas: ");
				notas[i][j] = teclado.nextInt();
			}
		}

//		RECORRIDO 
		for (int i = 0; i < tEstudiantes; i++) {
			System.out.println(apyn[i] + " ");
			for (int j = 0; j < tNotas; j++) {
				System.out.println(notas[i][j] + " ");
			}
		}

//		PROMEDIOS
		for (int i = 0; i < tEstudiantes; i++) {
			promedio[i] = 0;
			suma[i] = 0;
			for (int j = 0; j < tNotas; j++) {
				suma[i] += notas[i][j];
				promedio[i] = suma[i] / tNotas;
			}
		}

//		SI APRUEBAN O NO 
		for (int i = 0; i < tEstudiantes; i++) {
			if (promedio[i] >= 7) {
				System.out.println(
						"El estudiante " + apyn[i] + " tiene un promedio de " + promedio[i] + " aprueba la materia.");
			} else {
				System.out.println(
						"El estudiante " + apyn[i] + " tiene un promedio de " + promedio[i] + " reprueba la materia.");
			}
		}

		for (int i = 0; i < tEstudiantes; i++) {
			mayor = notas[0][0];
			int pos = 0;
			for (int j = 0; j < tNotas; j++) {
				if (notas[i][j] > mayor) {
					mayor = notas[i][j];
					pos = i;
				}
			}
			System.out.println("El estudiante con la mayor nota es "+apyn[pos]);
			System.out.println("Su calificacion es: "+mayor);
		}
		
		
	}

}
