package mio_clase;
/*
* Ordenar por bloques, cogiendo los 2 primeros, los 3 primeros, etc
* 7, 1, 0, -1, 3
* 1, 7, 0, -1, 3
* 0, 1, 7, -1, 3
* -1, 0, 1, 7, 3
*/

/*
* Otro enfoque: bucle que dure hasta que el anterior sea menor o hasta que llegue al primer elemento
*/

public class Ej49{
	public static void main(String[] args) {
		int vector[] = {2, -1, 0, 6, 1, 3, 4, -5, 15, 5, -4};
		int aux = 0;
		int min = 0;
		//
		System.out.println("El vector es: ");
		System.out.printf("{ ");
		for (int i = 0; i < vector.length; ++i){
			System.out.printf("%d ",vector[i]);
		}
		System.out.printf("}%n%n");
		//
		for (int i = 1; i < vector.length; ++i){
			for (int j = 0; j <= i; ++j){
				if (j != 0 && vector[j] < vector[j - 1]){
					aux = vector[j - 1];
					vector[j - 1] = vector[j];
					vector[j] = aux;
					j = 0;
				}
			}
		}
		//
		System.out.println("El vector es: ");
		System.out.printf("{ ");
		for (int i = 0; i < vector.length; ++i){
			System.out.printf("%d ",vector[i]);
		}
		System.out.printf("}%n%n");
		//
	}
}