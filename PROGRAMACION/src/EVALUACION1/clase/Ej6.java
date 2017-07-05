package EVALUACION1.clase;
						/*Saber si un numero es par o impar*/
						
				/*Si un numero es par, al dividirlo por 2 su resto no es 0.*/
				
public class Ej6{

	public static void main(String arg[]){
		
		int x = 0;
		
		if (x % 2 != 0){
			System.out.printf("El número %d es impar.\n", x);
		} else {
			System.out.printf("El número %d es par.\n", x);
		}
		
///*	
	 	for (int i = 0; i <= 100; ++i){ //13578 lo cuelga
			if (i % 2 != 0){
			System.out.printf("El número %d es impar.\n", i);
		} else {
			System.out.printf("El número %d es par.\n", i);
		}
	 	}
//*/
		
	}
}