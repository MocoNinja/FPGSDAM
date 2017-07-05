package EVALUACION1.rehechoRepaso;

public class VectorEnterosInvetir {

	public static void main(String[] args) {
		
		int[] vector = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		leerVectorEntero(invertirVectorEntero(vector));
	}
	
	public static int[] invertirVectorEntero(int[] vector){
		int limite = vector.length / 2;
		int aux = 0;
		
		for (int i = 0; i <= limite; i++){
			aux = vector[vector.length - 1 - i];
			vector[vector.length - 1 - i] = vector [i];
			vector[i] = aux;
		}
	return vector;
	}

	public static void leerVectorEntero(int[] vector){
		System.out.print("{ ");
		for (int i = 0; i < vector.length; i++){
			System.out.print(vector[i]);
			System.out.print(" ");
		}
		System.out.print("}\n");
	}
	
}
