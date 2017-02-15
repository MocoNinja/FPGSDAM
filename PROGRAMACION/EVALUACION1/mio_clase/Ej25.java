package mio_clase;
/*
* Hacer un ejercicio del estilo de los anteriores mostrando todos los desplazamientos
*/

public class Ej25{
	public static void main(String arg[]){
		int datos[] = {0, 1, 2, 3, 4};
		System.out.printf("El vector iterado 0 veces es: { ");
			for (int i = 0; i < datos.length; ++i){
				System.out.printf("%d ", datos[i]);
			}
		System.out.printf("}\n");
		for (int i = 1; i <= datos.length; ++i){
			int aux = datos[datos.length - 1];
			for (int j = datos.length - 1; j > 0; --j){
				datos[j] = datos [j - 1];
			}
			datos[0] = aux;
			System.out.printf("El vector iterado %d veces es: { ", i);
			for (int j = 0; j < datos.length; ++j){
				System.out.printf("%d ", datos[j]);
			}
		System.out.printf("}\n");
		}
	}
}