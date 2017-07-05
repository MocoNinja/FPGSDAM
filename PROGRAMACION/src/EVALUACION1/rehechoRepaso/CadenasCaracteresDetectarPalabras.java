package EVALUACION1.rehechoRepaso;

public class CadenasCaracteresDetectarPalabras {

	public static void main(String[] args) {
		
		char[] palabra = {'E', 'j', 'e', 'm', 'p', 'l', 'o', ' ', '1', ' ', 'f', 't', 'w'};
		System.out.print(palabra);
		System.out.println(" tiene: " + numeroPalabras(palabra) + " palabras...");
	}
	
	public static int numeroPalabras(char[] palabra){
		int palabras = 1;
		for (int i = 0; i < palabra.length; i++){
			if (palabra[i] == ' ')
				palabras++;
		}
	return palabras;
	}

}
