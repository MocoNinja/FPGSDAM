package EVALUACION1.clase;
/*
*
*/

public class Ej53{
	
	public static void main(String arg[]){
		int numeros [][] = {{1,2,3},{4,5,6},{7,8,9}};
		leer(numeros);
		System.out.printf("La suma de todos los elementos de ese vector es %d.%n", sumar(numeros));
	}	
		
	public static void leer(int vector[][]){
		System.out.printf("El vector es:%n%n");
		for (int i = 0; i < vector.length; ++i){
			System.out.printf("{");
			for (int j = 0; j < vector[i].length; ++j){
				System.out.printf(" %d ", vector[i][j]);
			}
			System.out.printf("}%n");
		}
		System.out.println();
	}
	
	public static int sumar(int vector[][]){
		int suma = 0;
		for (int i = 0; i < vector.length; ++i){
			for (int j = 0; j < vector[i].length; ++j){
				suma += vector[i][j];
			}
		}
	return suma;
	}
}