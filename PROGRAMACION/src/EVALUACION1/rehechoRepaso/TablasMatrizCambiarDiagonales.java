package EVALUACION1.rehechoRepaso;

public class TablasMatrizCambiarDiagonales {

	public static void main(String[] args) {
		
		int matriz[][] = {{0,1,2}, {3,4,5,}, {6,7,8}};
		int salva = 0;
		
		for (int i = 0; i < matriz.length; i++){
			salva = matriz[i][i];
			matriz[i][i] = matriz[i][matriz.length - 1 - i];
			matriz[i][matriz.length - 1 - i] = salva;
		}
		TablaLeer.leerVectorEntero(matriz);
	}

}
