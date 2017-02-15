package mio_estudiar;

public class CadenasCaracteresAnadeLetrasFinPalabra {

	public static void main(String[] args) {
		
		char[] frase = {'E', 'j', 'e', 'm', 'p', 'l', 'o', ' ', '1', ' ', 'f', 't', 'w'};
		System.out.println(creando(frase, 'x'));
	}
	
	public static char[] creando(char[] frase, char caracter){
	
		int caracteresMeter = CadenasCaracteresDetectarPalabras.numeroPalabras(frase) - 1; /*Esto es, sin contar la última*/
		char[] palabraNueva = new char[frase.length + caracteresMeter];
		int indice = 0;
		
		for (int i = 0; i < frase.length; i++, indice++){
			if( i != frase.length - 1 && frase[i + 1] == ' '){
				palabraNueva[indice] = frase[i];
				indice++;
				palabraNueva[indice] = caracter;
			} else {
				palabraNueva[indice] = frase[i];
			}
		}
	return palabraNueva;
	}

}
