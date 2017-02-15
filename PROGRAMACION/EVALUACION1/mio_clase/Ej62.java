package mio_clase;

/*
* Hacer lo anterior, pero creando una nueva tabla para no sobreescribir los kilos
*/

public class Ej62 {

	public static void main(String[] args) {
		
		int [][] kilosVendidos = {{3,5,7,2,5,7,1},{8,5,9,3,5,6,2}};
		int[] precios = {2,3};
		Funciones.muestraTablaEnteros(calculaVentas(kilosVendidos, precios));
		/*
		* En clase ha hecho:
		* int ventas[][]; -> esto es, por ahora, un null pointer
		* en la funcion, hace lo mismo exactamente
		* luego en main, asigna a ventas la funcion. 
		*/
	}
	
	public static int[][] calculaVentas(int [][] tabla, int[] vector){ 
		
		int[][] resultado = new int[tabla.length][tabla[0].length]; 
		//esto reserva posiciones de memoria para 2 x 7 enteros, guardando la del primero en resultado
		for (int i = 0; i < tabla.length; ++i){
			for (int j = 0; j < tabla[i].length; ++j){
				resultado[i][j] = tabla[i][j] * vector[i];
			}
		}
	return resultado;	//ojo, que también está devolviendo una direccón de memoria, no el vector en si.
	}
	
}
