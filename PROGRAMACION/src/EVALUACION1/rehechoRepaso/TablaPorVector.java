package EVALUACION1.rehechoRepaso;

public class TablaPorVector {

	public static void main(String[] args) {
		
		int matriz[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
		int vector[] = {0, 1, -1};
		
		for (int i = 0; i < matriz.length; i++){
			for (int j = 0; j < matriz[i].length; j++){
				matriz[i][j] *= vector[j];
			}
		}
		TablaLeer.leerVectorEntero(matriz);

	}

}
