package mio_clase;

/*
* Array 2x7 Números enteros (kilos vendidos de los productos)
* Vector 2x1 con el precio de cada producto
* Hacer una funcion a la que se le pasen las tablas kilos y precio, y devuelva la tablade kilos multiplicadas por el precio
*/

public class Ej61 {

	public static void main(String[] args) {

		int [][] kilosVendidos = {{3,5,7,2,5,7,1},{8,5,9,3,5,6,2}};
		int[] precios = {2,3};
		multiplicaTabla(kilosVendidos, precios);
		Funciones.muestraTablaEnteros(kilosVendidos);
		
	}
	
	private static void multiplicaTabla(int[][] tabla, int[] vector) {
			
			for (int i = 0; i < tabla.length; ++i){
				for (int j = 0; j < tabla[i].length; ++j){
					tabla[i][j] *= vector[i];
				}
			}
			
		}
		
}
