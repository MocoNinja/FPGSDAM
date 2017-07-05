package EVALUACION1.clase;
/*
* Partimos de una tabla de enteros, por ejemplo, de 4x4
* Copiamos la funcion ordenar, tal cual como esta en el ejercicio anterior
* Ordenamos la tabla por filas (SOLO por filas)
*/

/*Ojo el que vector 3, y solo el vector 3, esta mal ordenado*/
public class Ej56{
	
	public static void main(String arg[]){
		int datos[][] = {{0, -1, 3, -4},{10, 12, 32, 23},{1,-5,3,-4},{3, -4, 9, 12}};
		for (int i = 0; i < datos.length; ++i){
			leer(ordenaVector(filaAVector(datos, i)));
		}
	}
	
	public static int[] filaAVector(int tabla[][], int indice){
		int fila[] = new int[tabla[indice].length];
		for (int i = 0; i < tabla[indice].length; ++i){
			fila[i] = tabla[indice][i];
		}
	return fila;
	}
	
	public static int[] ordenaVector(int vector[]){
		for (int i = 1; i < vector.length; ++i){
			int j = i;
			int aux = 0;
			while((j > 0) && (vector[j] < vector[j - 1])){
				aux = vector[j];
				vector[j] = vector [j - 1];
				vector[j - 1] = aux;
				--j;
			}
		}
	return vector;
	}
	
	public static void leer(int vector[]){
		System.out.printf("El vector es:%n{");
		for (int i = 0; i < vector.length; ++i){
				System.out.printf(" %d ", vector[i]);
			}
		System.out.printf("}%n");
	}
}