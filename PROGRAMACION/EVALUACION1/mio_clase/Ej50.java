package mio_clase;
/*
* El anterior bien hecho
* 10 lineas menos de codigo
* 2 horas menos de trabajo
* Moraleja: Haz caso de tu instinto, guapo <3
*/

public class Ej50{
	public static void main(String arg[]){
		//->
		int vector[] = {5, 6, 25, 4, 16, 55, 33, 1, 2, 3};
		int aux = 0;
		//<-
		//->
		System.out.println("El vector es: ");
		System.out.printf("{ ");
		for (int i = 0; i < vector.length; ++i){
			System.out.printf("%d ",vector[i]);
		}
		System.out.printf("}%n%n");
		//<-
/*
 		//->
		// Esto lo he hecho yo. Recordar que asi hay que resetear el bucle igual!!
		for (int i = vector.length - 1; i >= 1; --i){
			while (vector[i] < vector[i - 1]){
				aux = vector[i - 1];
				vector [i - 1] = vector[i];
				vector[i] = aux;
				i = vector.length - 1;
			}
		}
		//<-
*/	
		//->
		// Así hecho en clase
		//int z = 3;
		for(int i = 1; i < vector.length; ++i){
			int z = i; //ojo a esto. Los bucles deben llevar variables distintas!!!
			while (z > 0 && (vector[z] < vector [z - 1])){
				/*
				* Recordar la tabla del and, que si lo pongo detras no rula
				* Porque en los casos que da excepcion la segunda se cumple y puede alterar la condicion &&
				* Poniendo esta la primera, cuando sea falso negara todo de golpe
				*/
				aux = vector[z - 1];
				vector [z - 1] = vector[z];
				vector[z] = aux;
				--z; //Da lo mismo que mi metodo. Recordar que el while requiere cambios propios!!
			}
		}
		//<-
		//->
		System.out.println("El vector es: ");
		System.out.printf("{ ");
		for (int i = 0; i < vector.length; ++i){
			System.out.printf("%d ",vector[i]);
		}
		System.out.printf("}%n%n");
		//<-
	}
}