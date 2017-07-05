package EVALUACION1.clase;

/*
* Tabla 4x4
* Funcion: se le pasa la tabla y un entero
* Devuelve la tabla multiplicada por el valor
* 
* Lo he hecho por punteros
*/

public class Ej60 {

	public static void main(String[] args) {
		
		int [][] numeros = {{3,5,7,2},{8,5,9,3},{7,2,9,6},{9,6,3,8}};
		int multiplicador = 10;
		multiplicaTabla(numeros, multiplicador);
		muestraTabla(numeros);
	}

	private static void muestraTabla(int[][] tabla) {
		System.out.println("La tabla es: ");
		for (int i = 0; i < tabla.length; ++i){
			System.out.printf("{");
			for (int j = 0; j < tabla[i].length; ++j){
				System.out.printf(" %d ", tabla[i][j]);
			}
			System.out.printf("}%n");
		}
		
	}

	private static void multiplicaTabla(int[][] tabla, int multiplicador) {
		
		for (int i = 0; i < tabla.length; ++i){
			for (int j = 0; j < tabla[i].length; ++j){
				tabla[i][j] *= multiplicador;
			}
		}
		
	}

}
