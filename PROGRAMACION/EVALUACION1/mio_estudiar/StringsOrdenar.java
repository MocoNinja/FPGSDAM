package mio_estudiar;

public class StringsOrdenar {

	public static void main(String[] args) {

		String[] nombres = {"Pepe", "Juan", "Ana", "Zelda", "Bea"};
		
		ordenaVectorStringsMenosaMas(nombres);
		for (int i = 0; i < nombres.length; i++){
			System.out.println(nombres[i]);
		}
		System.out.println();
		ordenaVectorStringsMasaMenos(nombres);
		for (int i = 0; i < nombres.length; i++){
			System.out.println(nombres[i]);
		}
	}
	
	public static void ordenaVectorStringsMenosaMas(String[] vector){
		String aux = null;
		for(int j = 1; j < vector.length; j++){ //Método de la burbuja para ordenarlo
			for (int i = 0; i < vector.length - j; i++){
				if (vector[i].compareTo(vector[i + 1]) < 0){ //El nombre de la derecha va antes alfabéticamente
					aux = vector[i];
					vector[i] = vector[i + 1];
					vector[i + 1] = aux;
				}
			}
		}
	}
	
	public static void ordenaVectorStringsMasaMenos(String[] vector){
		String aux = null;
		for(int j = 1; j < vector.length; j++){
			for (int i = 0; i < vector.length - j; i++){
				if (vector[i].compareTo(vector[i + 1]) > 0){ //El nombre de la izquierda va antes alfabéticamente
					aux = vector[i];
					vector[i] = vector[i + 1];
					vector[i + 1] = aux;
				}
			}
		}
	}

}