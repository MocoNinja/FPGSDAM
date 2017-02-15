package mio_estudiar;

public class TablasTransponerMatriz {

	public static void main(String[] args) {
		
		int matriz[][] = {{0,1,2}, {3,4,5}, {6,7,8}};
		
		dificil(matriz);
		
	}
	
	public static void dificil(int[][] matriz){
		int guarda = 0;
		for (int i = 0; i < matriz.length; i++){
			for (int j = i; j < matriz[i].length; j++){ //LA CHICHA
				guarda = matriz[j][i];
				matriz[j][i] = matriz[i][j];
				matriz[i][j] = guarda;
			}
		}
		TablaLeer.leerVectorEntero(matriz);
	}
	
	public static void facil(int[][] matriz){
		int traspuesta[][] = {{0,0,0}, {0,0,0}, {0,0,0}};
		for (int i = 0; i < matriz.length; i++){
			for (int j = 0; j < matriz[i].length; j++){
				traspuesta[j][i] = matriz[i][j];
			}
		}
		TablaLeer.leerVectorEntero(traspuesta);
	}

}
