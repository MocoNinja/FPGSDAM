package mio_clase;

/*
* Otra vez la misma tabla
* La modificamos de manera que los valores inferiores a 10, se multipliquen por el contenido de una variable, pasada a la funcion
*/

public class Ej64 {

	public static void main(String[] args) {

		int [][] kilosVendidos = {{3,5,7,2,5,7,10},{8,5,9,3,5,6,22}};
		int multiplicador = -4;
		multiplicaTabla(kilosVendidos, multiplicador);
		Funciones.muestraTablaEnteros(kilosVendidos);
		
	}
	
	private static void multiplicaTabla(int[][] tabla, int multiplicador) {
			for (int i = 0; i < tabla.length; ++i){
				for (int j = 0; j < tabla[i].length; ++j){
					if (tabla[i][j] < 10){
						tabla[i][j] *= multiplicador; 
					}
				}
			}	
	}

}
