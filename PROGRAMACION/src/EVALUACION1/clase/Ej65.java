package EVALUACION1.clase;

/*
* Vamos a tratar como cadenas de caracteres
* Un String es una cadena de caracteres, pero tambien hay otro tipo de dato: char
* char es un caracter: char = 'c'; Como en C, comillas simples (String, dobles);
* Podemos usar un vector de char para escribir mensajes
*/

public class Ej65 {

	public static void main(String[] args) {

		char[] frase = {'E', 'j', 'e', 'm', 'p', 'l', 'o', ' ', '1', ' ', 'f', 't', 'w'};
		for (int i = 0; i < frase.length; ++i){
			System.out.printf("%c", frase[i]);
		}
		System.out.println();
		System.out.println("La frase anterior esta compuesta por " + detectaPalabras(frase) + " palabra(s).");

	}
	
	public static int detectaPalabras(char[] frase){
		/*
		* Las palabras están separadas por espacios en blanco.
		* Habrá tantas palabras como espacios en blanco + 1 
		*/
		int contador = 1;
		for (int i = 1; i < frase.length; ++i){ /*Arranco en 1 por si el primer caracter es, por lo que sea, un espacio*/
			if (frase[i] == ' ')
				contador++;
		}
	return contador;
	}

}
