package EVALUACION1.rehechoRepaso;

public class VectorEnterosMueveValoresHaciaUnLado {

	public static void main(String[] args) {
		
		int vector[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		//leerVectorEntero(mueveDerecha(vector));
		leerVectorEntero(mueveIzquierda(vector));
	}
	
	public static int[] mueveDerecha(int[] vector){
		/*
		Como hay que mover a la derecha, recorriendo desde la izquierda se sobrescribe sólo un elemento.
		El último (primero en ser leido)
		*/
		
		int aux = vector[vector.length - 1];
		
		for (int i = vector.length - 1; i >=1; i--){
			vector[i] = vector[i - 1];
		}
		
		vector[0] = aux;
		
	return vector;
	}
	
	public static int[] mueveIzquierda(int[] vector){
		/*
		Al revés
		*/
		
		int aux = vector[0];
		
		for (int i = 0; i < vector.length - 1 ; i++){
			vector[i] = vector[i + 1];
		}
		
		vector[vector.length - 1] = aux;
		
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
