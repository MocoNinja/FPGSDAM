package mio_clase;
/*
*
*/

public class Ej52{
	
	public static void main(String arg[]){
		/*Declaramos una variable de tipo PUNTERO*/
		int numeros[] = {0, 1, -3, 5, 12, -4, 17, -22};
		int otrosNumeros[] = {10, 200, -2, -39, 87};
		/*Estamos pasando a la funcion el puntero; es decir, la direccion de memoria del primer elemento*/
		System.out.printf("El máximo del vector es: %d%n", maximo(numeros));
		System.out.printf("Y el máximo del otro vector es: %d%n", maximo(otrosNumeros));
		System.out.println("Magic!");
		leer(otrosNumeros);
		/*
		* vector [ direccion] -apunta->[RAAAAAAM]
		* v [ direccion ] -apunta------^
		*/
	}
	
	public static int maximo(int vector[]){ /*vector es otro puntero*/
		int max = 0;
		for (int i = 0; i < vector.length; ++i){
			if (vector[i] > max){
				max = vector[i];
			}
		}
		return max;
	}
	
	public static void leer(int vector[]){
		System.out.printf("El vector es:%n{");
		for (int i = 0; i < vector.length; ++i){
				System.out.printf(" %d ", vector[i]);
			}
		System.out.printf("}%n");
	}
	
}