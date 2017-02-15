package mio_clase;
 		//Factorial de un numero mediante un bucle for
public class Ej10{
	
	static int numero = 4; //hasta 31 llega sin dar 0; segun una página sólo están bien hasta 12
	public static void main(String arg[]){
		int resultado = numero;
		/*
		* 					Orden de ejecución (mah o menoh)
		*
		* Primera iteración: la asignación del iterador
		* Sucesivas: El incremento
		* Si después de este incremento se deja de cumplir la condición, se sale del bucle 
		* sin ejecutar nada de lo que hay
		*/
		for (int i = numero - 1; i >= 2; --i){
				resultado *= i;
		}
		System.out.printf("El factorial de %d es %d\n", numero, resultado);
		
		/* Yo he hecho el for al reves. Otra forma*/
/*		
 		resultado = 1;
		for (int i = 1; i <= numero; ++i){
			resultado *= i;
		}
		System.out.printf("El factorial de %d es %d\n", numero, resultado);
*/
	}
}
