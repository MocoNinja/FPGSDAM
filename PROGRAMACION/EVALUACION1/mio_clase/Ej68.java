package mio_clase;

public class Ej68 {

	public static void main(String[] args) {
		
		char[] frase = {'E', 'j', 'e', 'm', 'p', 'l', 'o', ' ', '1', ' ', 'f', 't', 'w'};
		sustituyeCaracteres(frase, 'e',  '2');
		System.out.println(frase);

	}
	
	public static void sustituyeCaracteres(char[] frase, char caracterASustituir, char caracterSustituto){
		for (int i = 0; i < frase.length; ++i){
			if (frase[i] == caracterASustituir)
				frase[i] = caracterSustituto;
		}
	}
}
