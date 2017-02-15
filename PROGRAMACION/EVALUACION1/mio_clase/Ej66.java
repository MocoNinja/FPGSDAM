package mio_clase;

/*
* Modificar la frase para que, después de cada palabra, añada una x (manteniendo el espacio)
* A el le esta dando problemas para sacar las 2 cadenas de caracteres
*  el caracter de fin de string es \0
*/
public class Ej66 {
	
	public static void main(String[] ar){
		
		char[] frase = {'E', 'j', 'e', 'm', 'p', 'l', 'o', ' ', '1', ' ', 'f', 't', 'w'};
		char[] fraseModicada = new char[100];
		char[] fraseModicada2 = addCharToFrase2(frase, 'x');
		addCharToFrase(frase, fraseModicada, 'x');
		/*
		for (int i = 0; i < fraseModicada.length; ++i)
			System.out.printf("%c", fraseModicada[i]);
		System.out.println();
		for (int i = 0; i < fraseModicada2.length; ++i)
			System.out.printf("%c", fraseModicada2[i]);
		*/
		System.out.println(fraseModicada);
		System.out.println(fraseModicada2);
	}

	public static void addCharToFrase(char[] origen, char[] frase, char caracter) {
		//int j = 0;
		/*hay fors con varias variables (for (int i = 0, j = 0; i < origen.length; ++i, ++j)*/
		//for (int i = 0; i < origen.length; ++i){
		for (int i = 0, j = 0; i < origen.length; ++i, ++j){
			if (origen[i] == ' '){
				frase[j] = caracter;
				j++;
			}
			frase[j] = origen[i];
			//j++;
		}
	}
	
	public static char[] addCharToFrase2(char[] origen, char caracter){
		char[] frase = new char[100];
		for (int i = 0, j = 0; i < origen.length; ++i, ++j){
			if (origen[i] == ' '){
				frase[j] = caracter;
				j++;
			}
			frase[j] = origen[i];
		}
	return frase;
	}
	
}
	
	
