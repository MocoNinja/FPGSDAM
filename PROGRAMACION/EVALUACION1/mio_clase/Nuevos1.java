package mio_clase;

/*
* Cadenas de caracteres
* Pedimos un caracter
* Sobre la misma cadena, eliminamos ese caracter 
*/
public class Nuevos1 {

	public static void main(String[] args) {
		
		char[] frase = {'F', 'e', 'd', 'e', 'r', 'i', 'c', 'o', ' ', 'f', 'e', 'o'};
		char caracter = 'e';
		int longitud = frase.length;
		System.out.print("'");
		System.out.print(frase);
		System.out.print("' pasa a: ");
		
		for (int i = 0; i < longitud; ++i){
			if (frase[i] == caracter){
				for (int j = i; j < longitud - 1; j++ ){
					frase[j] = frase[j + 1];
				}
				frase[longitud - 1] = ' ';
				longitud--;
			}
		}
		System.out.print("'");
		System.out.print(frase);
		System.out.print("'.");
	}

}
