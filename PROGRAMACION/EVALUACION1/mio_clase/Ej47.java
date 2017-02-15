package mio_clase;
/*
* Algoritmos de ordenación de vectores
* Método de la burbuja (visualizar un vector vertical, empezando desde abajo, subiendo hasta el elemento 0
* Se llama así porque los valores van subiendo hacia arriba
* Empieza por abajo y lo va subiendo, comparando con la anterior posicion
* (Si es mas pequeño, se intercambia y sube)
* Al hacer todas las iteraciones, se acaba ordenando el primer elemento (el mas pequeño en el elemento 0)
* Repitiendo esto en vectores de longitud n - 1, se ordenada todo
*/


public class Ej47 {
	public static void main(String arg[]){
		int numeros[] = {23, -23, 0, 25, 9, -34, 87, -45, 234, -450, 2445, 23, 189, -213, 235, -452, 132, -132, 0};
		int aux = 0;
		int longitud = numeros.length;
		//int finalnumber = 0; /*He metido esto para optimizar el codigo y no comparar lo ya ordenado*/
		/*Se puede omitir la variable*/
		System.out.println("El vector original es: ");
		System.out.printf("{ ");
		for (int i = 0; i < numeros.length; ++i){
			System.out.printf("%d ",numeros[i]);
		}
		System.out.printf("}%n%n");
		for (int veces = 0; veces < longitud - 1; ++veces){
			for (int elemento = longitud - 1; elemento > veces; --elemento){
				if (numeros[elemento] < numeros[elemento - 1]){
					aux = numeros[elemento - 1];
					numeros[elemento - 1] = numeros[elemento];
					numeros[elemento] = aux;
				}
			}
		}
		System.out.println("El vector nuevo es: ");
		System.out.printf("{ ");
		for (int i = 0; i < numeros.length; ++i){
			System.out.printf("%d ",numeros[i]);
		}
		System.out.printf("}%n%n");
	}
}