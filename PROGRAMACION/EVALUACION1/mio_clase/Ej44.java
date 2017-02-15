package mio_clase;
/*
* Matriz cuadrada
* Hay diagonal principal (a00 -> ann)
* Hay diagonal secundaria (a0n ->an0)
* Cambiar estas diagonales
* Hacerlo sobre una SOLA TABLA
*/

public class Ej44{
	public static void main(String arg[]){
		int matriz[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		int salva = 0;
//Display matriz inicial//////////////////////////////////////////////////////////////////////////////////////////////
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
//Matriz cambiada//////////////////////////////////////////////////////////////////////////////////////////////
		for (int i = 0; i < matriz.length; ++i){
			salva = matriz[i][i];
			//System.out.printf("Se ha salvado %d%n", salva);
			//System.out.printf("Hay que cambiar %d%n", matriz[i][matriz.length - i - 1]);
			matriz[i][i] = matriz[i][matriz.length - i - 1];
			/*
			* OJO QUE ME HA COSTADO UN HUEVO VER EL -1
			* LO HE ACABADO ANTES QUE EL PROFE PERO YA HABIA EMPEZADO A EXPLICARLO
			* OJO!!!!!
			*/
			matriz[i][matriz.length - i - 1] = salva;
		}
//Display matriz cambiada//////////////////////////////////////////////////////////////////////////////////////////////
		System.out.printf("La matriz cambiada es:\n");
			for (int fila = 0; fila < matriz.length; ++fila){
				System.out.printf("\n{");
				for (int columna = 0; columna < matriz[fila].length; ++columna){
				System.out.printf("%2d ", matriz[fila][columna]);
				}	
				System.out.printf("}");
			}
		System.out.println();
	}
}