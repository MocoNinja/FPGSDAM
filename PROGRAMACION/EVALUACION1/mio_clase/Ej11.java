package mio_clase;

/*Multiplicación mediante sumas*/
public class Ej11{
	
	static int numero1 = 9000000;
	static int numero2 = 40;
	
	public static void main(String arg[]){
		
		// Paja mental para hacer el menor numero de iteraciones
		
		int veces = 0; //multiplicador
		int suma = 0; //multiplicando
		int resultado = 0;
		
		if (numero1 <= numero2){
			veces = numero1;
			suma = numero2;
		} else {
			veces = numero2;
			suma = numero1;
		}
		for (int i = 1; i <= veces; ++i){
			resultado += suma;
		}
		System.out.println("El resultado es " + resultado);
	}
}