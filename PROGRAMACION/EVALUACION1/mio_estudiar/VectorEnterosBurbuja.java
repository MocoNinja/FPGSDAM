package mio_estudiar;

public class VectorEnterosBurbuja {
	
	public static void main(String[] args) {
		int[] vector = {0, -3, 4, 9, -8, -2, 7, -1};
		
		burbujaMayor(vector);
		burbujaMenos(vector);
	}
	
	public static void burbujaMayor(int[] vector){
		int aux = 0;
		for (int i = 1; i < vector.length; i++){
			for (int j = 1; j < vector.length; j++){
				if (vector[j] > vector[j - 1]){
					aux = vector[j - 1];
					vector[j - 1] = vector[j];
					vector[j] = aux;
				}
			}
		}
		VectorLeer.leerVectorEntero(vector);
	}
	
	public static void burbujaMenos(int[] vector){
		int aux = 0;
		for (int i = 0; i < vector.length - 1; i++){
			for (int j= 0; j < vector.length - 1; j++){
				if (vector[j + 1] < vector[j]){
					aux = vector[j];
					vector[j] = vector[j + 1];
					vector[j + 1] = aux;
				}
			}
		}
		VectorLeer.leerVectorEntero(vector);
	}
}
