package mio_clase;
/*
* Lo de antes, negativos por 5 y positivos negativos
*/
public class Ej30{
	public static void main(String arg[]){
		int tabla[][] = {{0, -1, 2}, {-3, 6, 0}, {4, -12, 21}};
		for (int i = 0; i < tabla.length; ++i){
			for (int j = 0; j < tabla[
				i].length; ++j){
				if (tabla[i][j] <= 0){
					tabla[i][j] = 5 * tabla[i][j];
				} else {
					tabla[i][j] = - tabla[i][j];
				}
				System.out.printf(" %3d ", tabla[i][j]);
			}
		System.out.println();
		}
	}
}