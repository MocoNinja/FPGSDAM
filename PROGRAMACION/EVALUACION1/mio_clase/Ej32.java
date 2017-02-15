package mio_clase;
public class Ej32{
	public static void main(String args[]) {
		int matriz[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
		int vector[] = {0, 1, -1};
		
/*					//ESTO NO ES LO QUE HA MANDADO
 
		for (int i = 0; i < matriz.length; ++i){
			for (int j = 0; j < matriz[i].length; ++j){
				for (int k = 0; k < vector.length; ++k){
					System.out.printf(" %2d ", matriz[i][j] * vector[k]);
				}
				System.out.print("\t");
			}
			System.out.println();
		}
*/
					//ESTO SI
		for (int i = 0; i < matriz.length; ++i){
				for (int j = 0; j < matriz[i].length; ++j){
					System.out.printf(" %2d ", matriz[i][j] * vector[i]);
				}
				System.out.println();
		}
	}
}