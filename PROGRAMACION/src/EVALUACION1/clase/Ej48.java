package EVALUACION1.clase;
/*
* Metodo de ordenacion 2:
* Vuelve a ser un método de ordenación parcial (ordenas una vez, y eso varias veces)
* Consiste en buscar el mínimo y moverlo al principio, poniendo en su posición el que ya estaba
*/
public class Ej48{
	public static void main(String arg[]){
		
		int vector[] = {0, -2, 5, 19, -34, -234, 32};
		int min = 0;
		int aux = 0;
		//
		System.out.println("El vector original es: ");
		System.out.printf("{ ");
		for (int i = 0; i < vector.length; ++i){
			System.out.printf("%d ",vector[i]);
		}
		System.out.printf("}%n%n");
		//
		for (int veces = 0; veces < vector.length - 1; ++veces){
			min = veces; /*OJO QUE NO SE OLVIDE ESTO*/
			for (int i = veces; i < vector.length; ++i){
				if (vector[i] < vector[min]){
					min = i;
				}
			}
				aux = vector[veces];
				vector[veces] = vector[min];
				vector[min] = aux;
		}
		//
		System.out.println("El vector nuevo es: ");
		System.out.printf("{ ");
		for (int i = 0; i < vector.length; ++i){
			System.out.printf("%d ",vector[i]);
		}
		System.out.printf("}%n%n");
	}
}