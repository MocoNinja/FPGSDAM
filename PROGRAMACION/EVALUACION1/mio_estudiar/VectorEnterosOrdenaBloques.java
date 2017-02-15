package mio_estudiar;

public class VectorEnterosOrdenaBloques {
	
	/*
	* Ordenar por bloques, cogiendo los 2 primeros, los 3 primeros, etc
	* 7, 1, 0, -1, 3
	* 1, 7, 0, -1, 3
	* 0, 1, 7, -1, 3
	* -1, 0, 1, 7, 3
	*/

	public static void main(String[] args) {
		
		int vector[] = {2, -1, 0, 6, 1, 3, 4, -5, 15, 5, -4};
		ordenaBloques(vector);
		VectorLeer.leerVectorEntero(vector);		
	}
	
	public static void ordenaBloques(int[] vector){
		int aux = 0;
		int j;
		for (int i = 1; i < vector.length; i++){
			j = 1;
			while(j <= i){
				if (vector[j - 1] > vector[j]){
					aux = vector[j - 1];
					vector[j - 1] = vector[j];
					vector[j] = aux;
					j = 1; /*Cuidadin a esto*/
				}
				j++;
			}
		}
	}
	
}
