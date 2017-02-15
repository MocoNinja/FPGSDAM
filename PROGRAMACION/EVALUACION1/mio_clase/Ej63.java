package mio_clase;

/*
* Mismo vector de antes que los kilos
* Hacer una funcion que devuelva cuantos kilos se han vendido de cada producto
* Devolver un vector de dos elementos
*/

public class Ej63 {

	public static void main(String[] args) {
		int [][] kilosVendidos = {{1, 9, 7, 3, 8, 2},{2, 10, 8, 4, 9, 3}};
		String[] productos = {"Sandías", "Cerezas"};
		int beneficios[] = acumulaKilos(kilosVendidos);
		for (int i = 0; i < productos.length; ++i)
			System.out.printf("Se han vendido %3d kilos de %s.%n", beneficios[i], productos[i]);

	}

	private static int[] acumulaKilos(int[][] tabla) {
		int[] ventasTotales = new int[tabla.length];
		for (int i = 0; i < tabla.length; ++i){
			for (int j = 0; j < tabla[i].length; ++j){
				ventasTotales[i] += tabla[i][j]; //OLVIDARSE DE USAR VARIABLES ACUM PARA ESTAS COSAS!!!!!1!!!!
			}
		}
	return ventasTotales;
	}
	
}
