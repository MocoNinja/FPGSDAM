package mio_clase;
						/*Sacar el menor de 3 variables*/

public class Ej5{

	public static void main(String arg[]){
		
		int x = 1330;
		int y = 30;
		int z = 130;
		
		if (x < y && x < z){
			System.out.printf("%d es mínimo.\n", x);
		} else if (y < x && y < z){
			System.out.printf("%d es mínimo.\n", y);
		} else if (z < x && z < y){
			System.out.printf("%d es mínimo.\n", z);
		} else {
			System.out.println("No hay mínimo.");
		}	
			
		/*			//Con ifs dentro de ifs
		
		if (x < y){
			if (x < z){
				System.out.println("x es el mínimo.");
			} else {
				System.out.println("z es el mínimo.");
			}
		} else if (y < x){
			if (y < z){
				System.out.println("y es el mínimo.");	
			} else {
				System.out.println("z es el mínimo.");
			}
		} else {
			System.out.println("No hay mínimo.");
		}
		*/
	}
}