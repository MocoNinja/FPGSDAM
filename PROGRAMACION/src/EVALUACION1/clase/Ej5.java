package EVALUACION1.clase;
						/*Sacar el menor de 3 variables*/

public class Ej5{

	public static void main(String arg[]){
		
		int x = 1330;
		int y = 30;
		int z = 130;
		
		if (x < y && x < z){
			System.out.printf("%d es m�nimo.\n", x);
		} else if (y < x && y < z){
			System.out.printf("%d es m�nimo.\n", y);
		} else if (z < x && z < y){
			System.out.printf("%d es m�nimo.\n", z);
		} else {
			System.out.println("No hay m�nimo.");
		}	
			
		/*			//Con ifs dentro de ifs
		
		if (x < y){
			if (x < z){
				System.out.println("x es el m�nimo.");
			} else {
				System.out.println("z es el m�nimo.");
			}
		} else if (y < x){
			if (y < z){
				System.out.println("y es el m�nimo.");	
			} else {
				System.out.println("z es el m�nimo.");
			}
		} else {
			System.out.println("No hay m�nimo.");
		}
		*/
	}
}