package EVALUACION1.clase;
						/*Sacar el mayor de 3 variables*/

public class Ej4{

	public static void main(String arg[]){
		
		int x = 10;
		int y = 0;
		int z = 0;
		
					// The "C��l" Way
		
		if (x > y && x > z){
			System.out.printf("%d es m�ximo.\n", x);
		} else if (y > x && y > z){
			System.out.printf("%d es m�ximo.\n", y);
		} else if (z > x && z > y){
			System.out.printf("%d es m�ximo.\n", z);
		} else {
			System.out.println("No hay m�ximo.");
		}	
			
		/*			//Con ifs dentro de ifs
		
		if (x > y){
			if (x > z){
				System.out.println("x es el m�ximo.");
			} else {
				System.out.println("z es el m�ximo.");
			}
		} else if (y > x){
			if (y > z){
				System.out.println("y es el m�ximo.");	
			} else {
				System.out.println("z es el m�ximo.");
			}
		} else {
			System.out.println("No hay m�ximo.");
		}
		*/
	}
}