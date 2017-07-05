package EVALUACION1.clase;

/*
* Cadenas de caracteres
* Pedimos una cadena de caracteres
* Sobre la misma cadena, eliminamos ese caracter 
*/
public class Nuevos2 {

	public static void main(String[] args) {
		
		char[] frase = {'F', 'e', 'd', 'e', 'r', 'i', 'c', 'o', ' ', 'f', 'e', 'o'};
		char[] caracter = {'e', 'd', 'e'};
		int longitud = frase.length;
		int coincidencias;
		
		System.out.print("'");
		System.out.print(frase);
		System.out.print("' pasa a: ");
		
		
		for (int i = 0; i <= longitud - caracter.length; ++i){
			coincidencias = 0;
			if (frase[i] == caracter[0]){
				coincidencias++;
				while (coincidencias < caracter.length && frase[i + coincidencias] == caracter[coincidencias])
					coincidencias++;
				if (coincidencias == caracter.length){ //SI ESTA LA SUBCADENA, HAY QUE REPETIR LO DE NATES
					//System.out.println("Puff, habría que mover");
					for (int j = i; j < longitud - caracter.length; j++ ){
						frase[j] = frase[j + caracter.length];
					}
					for (int j = longitud - 1; j >= longitud - caracter.length; j--){
						frase[j] = ' ';
					}
					longitud -= caracter.length;
				}
			}
		}
		System.out.print("'");
		System.out.print(frase);
		System.out.print("'.");
		
	}

}
