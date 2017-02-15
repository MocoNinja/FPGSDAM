package mio_clase;
						/*Saber si acaba en 5*/
	/*Un número acaba en la cifra n, si el resto del número dividido por 10 es n*/
				
public class Ej7{

	public static void main(String arg[]){
		int numero = 15;
		
		if (numero % 10 == 5){
			System.out.println(numero + " acaba en 5");
		} else {
			System.out.println(numero + " NO acaba en 5");
		}
		
	/*Este es un algoritmo más complicado y menos original, general y eficiente,
	* pero al menos funciona
	*/
	
		/*
		if ((numero % 5) == 0 && (numero % 2) != 0){
			System.out.println(numero + " acaba en 5");
		} else {
			System.out.println(numero + " NO acaba en 5");
		}
		*/
	}
}