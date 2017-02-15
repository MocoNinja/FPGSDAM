package mio_clase;

public class Funciones {

	static void muestraTablaEnteros(int[][] tabla) {
		System.out.println("La tabla es: ");
		for (int i = 0; i < tabla.length; ++i){
			System.out.printf("{");
			for (int j = 0; j < tabla[i].length; ++j){
				System.out.printf(" %3d ", tabla[i][j]);
			}
			System.out.printf("}%n");
		}
	}
	
	static void muestraVectorEnteros(int[] vector){
		System.out.printf("{");
		for (int i = 0; i < vector.length; ++i){
			System.out.printf(" %1d ", vector[i]);
		}
		System.out.printf("}%n");
	}
}
