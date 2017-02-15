package mio_clase;

/*
* En una cadena, poner la primera y ultima letra de cada palabra en mayuscula
* Cambiar las vocales por 'X' 
*/
public class Nuevo32{

	public static void main(String[] args) {
		char[] palabra = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'u', 'n', 'o'};
		char caracter = 'z';
		//cambiaVocal(palabra, caracter);
		capitaliza(palabra, caracter);
		
	}
	
	public static void cambiaVocal(char[] palabra, char caracter){
		for (int i = 0; i < palabra.length; i++){
			if (palabra[i] == 'a' || palabra[i] == 'i' || palabra[i] == 'u' || palabra[i] == 'e' || palabra[i] == 'o' || palabra[i] == 'A' || palabra[i] == 'I' || palabra[i] == 'U' || palabra[i] == 'E' || palabra[i] == 'O'){
				
				palabra[i] = caracter;
			}
		}
		System.out.println(palabra);
	}
	
	public static void capitaliza(char[] palabra, char caracter){
		int indice = 0;
		int inicio = indice;
		
		while (indice < palabra.length){
			if (indice == palabra.length - 1 || palabra[indice + 1] == ' '){
				palabra[inicio] = Character.toUpperCase(palabra[inicio]);
				palabra[indice] = Character.toUpperCase(palabra[indice]);
				indice += 2;
				inicio = indice;
			} else {
				indice++;
			}
			
		}
		System.out.println(palabra);
	}
	
}
