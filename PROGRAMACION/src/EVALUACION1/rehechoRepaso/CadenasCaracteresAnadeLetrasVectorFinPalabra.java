package EVALUACION1.rehechoRepaso;

public class CadenasCaracteresAnadeLetrasVectorFinPalabra {

	public static void main(String[] args) {
		
		char[] frase = {'E', 'j', 'e', 'm', 'p', 'l', 'o', ' ', '1', ' ', 'f', 't', 'w'};
		char[] entrada = {'e', 'z'};
		
		System.out.println(creando(frase, entrada));
	}
	
	public static char[] creando(char[] frase, char[] caracteres){
	
		int caracteresMeter = caracteres.length * (CadenasCaracteresDetectarPalabras.numeroPalabras(frase)); /*Esto es, sin contar la última*/
		char[] palabraNueva = new char[frase.length + caracteresMeter];
		//char[] palabraNueva = new char[1000];
		int indice = 0;
		
		for (int i = 0; i < frase.length; i++, indice++){
			
			if( i != frase.length - 1 && frase[i + 1] == ' '){
				palabraNueva[indice] = frase[i];
				indice++;
				for (int j = 0; j < caracteres.length; j++){
					palabraNueva[indice] = caracteres[j];
					indice++;
				}
			} else {
				palabraNueva[indice] = frase[i];
			}
		}
	return palabraNueva;
	}

}