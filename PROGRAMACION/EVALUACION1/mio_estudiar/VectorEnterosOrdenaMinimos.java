package mio_estudiar;

public class VectorEnterosOrdenaMinimos {

	public static void main(String[] args) {
		
		int[] vector = {0, -3, 4, 9, -8, -2, 7, -1};
		ordenaMinimos(vector);
		ordenaMaximos(vector);
	}
	
	public static void ordenaMinimos(int[] vector){
		int aux = 0;
		for (int i = 0; i < vector.length; i++){
			for (int j = i; j < vector.length; j++){
				if (vector[j] < vector[i]){
					aux = vector[i];
					vector[i] = vector[j];
					vector[j] = aux;
				}
			}
		}
		VectorLeer.leerVectorEntero(vector);
	}
	
	public static void ordenaMaximos(int[] vector){
		int aux = 0;
		for (int i = 0; i < vector.length; i++){
			for (int j = i; j < vector.length; j++){
				if (vector[j] > vector[i]){
					aux = vector[i];
					vector[i] = vector[j];
					vector[j] = aux;
				}
			}
		}
		VectorLeer.leerVectorEntero(vector);
	}

}
