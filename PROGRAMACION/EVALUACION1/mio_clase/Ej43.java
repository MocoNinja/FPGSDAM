package mio_clase;
/*
* Sacar la matriz traspuesta
* Partiendo solo de la tabla original
* a00 -> a00
* a01 -> a10
* a02 -> a20
* ---
* aij -> aji
*
* Hay que salvarlo
* a10 -> guardar
* a01 -> a10
* a01 -> guardar
* aji -> aij
* aux -> aji
*/
public class Ej43{
	public static void main(String arg[]){
		int matriz[][] = {{0,1,2,3}, {4,5,6,7}, {8,9,10,11}, {12,13,14,15}};
		int guarda = 0;
//  Display matriz inicial
		System.out.printf("La matriz original es:\n");
			for (int fila = 0; fila < matriz.length; ++fila){
				System.out.printf("\n{");
				for (int columna = 0; columna < matriz[fila].length; ++columna){
				System.out.printf("%2d ", matriz[fila][columna]);
				}	
				System.out.printf("}");
			}
		System.out.println();
		System.out.println();
//////////////////////////////////////////
//  Transpose
	for (int j= 0; j < matriz.length; ++j)
		for (int i = j; i < matriz[j].length; ++i){  
		//ojo que este bucle me ha costado. 
		//Pero bueno, era el problema comun. Asi que nise. GG EZ!!
				guarda = matriz[i][j];
				matriz[i][j] = matriz[j][i];
				matriz[j][i] = guarda;
		}
//////////////////////////////////////////
//  Display matriz tranpuesta
		System.out.printf("La matriz traspuesta es:\n");
			for (int fila = 0; fila < matriz.length; ++fila){
				System.out.printf("\n{");
				for (int columna = 0; columna < matriz[fila].length; ++columna){
				System.out.printf("%2d ", matriz[fila][columna]);
				}	
				System.out.printf("}");
			}
		System.out.println();
//////////////////////////////////////////
	}
}