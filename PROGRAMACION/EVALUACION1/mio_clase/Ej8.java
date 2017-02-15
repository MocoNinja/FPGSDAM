package mio_clase;
						/*Saber si un numero es multiplo del otro*/
						
				
public class Ej8{

	public static void main(String arg[]){
		int numero1 = 5;
		int numero2 = 15;
	/*	if (numero1 < numero2){
			int max = numero2;
			int min = numero1;
		} else {
			int max = numero1;
			int min = numero2;
		}
		Al calcular el cociente de esto, me ha empezado a escupir errores de compilación con la
		misma lógica. Investigarlo.
	*/ 
		//Hacerlo con una variable auxiliar
		
		if(numero1 < numero2){
			int aux = numero1;
			numero1 = numero2;
			numero2 = aux;
		}
		if (numero1 % numero2 == 0){
			System.out.printf("%d y %d son múltiplos.\n", numero1, numero2);
		} else {
			System.out.printf("%d y %d NO son múltiplos.\n", numero1, numero2);
		}
	}
}