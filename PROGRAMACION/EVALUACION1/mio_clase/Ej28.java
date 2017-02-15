package mio_clase;
/*
* Tabla de multiplicar
*/
public class Ej28{
	public static void main(String arg[]){
		int numeros[] = {0, 1,2,3,4,5,6,7,8,9,10};
		int multiplicandos[] = {0, 1,2,3,4,5,6,7,8,9,10};
		System.out.printf("\n\n");
		for (int i = 1; i < numeros.length; ++i){
			System.out.printf("Tabla de multiplicar del %2d: [", i);
			for (int j = 1; j < multiplicandos.length; ++j){
				System.out.printf(" %2d x %2d =%3d   ",i, j, numeros[j]*multiplicandos[i]);
			}
			System.out.print("]");
			System.out.printf("\n\n");
		}
	}
}