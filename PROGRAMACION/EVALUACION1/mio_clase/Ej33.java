package mio_clase;
/*
* Ejercicio típico de tablas
* Tenemos una tabla  3x4
* La suma de las filas, será un vector (3x1)
* La suma de las columnas, otro (1x4)
*/

public class Ej33{
	public static void main(String arg[]){
		int tabla [][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int vectorFilas[] = {0, 0, 0};
		int vectorColumnas[] = {0, 0, 0, 0};
		for (int i = 0; i < tabla.length; ++i){
			for (int j = 0; j < tabla[i].length; ++j){
				vectorFilas[i] += tabla[i][j];
				vectorColumnas[j] += tabla[i][j];
			}	
		}
		
		System.out.printf("El vector Filas es: { ");
			for (int i = 0; i < vectorFilas.length; ++i){
				System.out.printf("%d ", vectorFilas[i]);
			}
		System.out.printf("}\n");
		System.out.printf("El vector Columnas es: { ");
			for (int i = 0; i < vectorColumnas.length; ++i){
				System.out.printf("%d ", vectorColumnas[i]);
			}
		System.out.printf("}\n");
	}
}