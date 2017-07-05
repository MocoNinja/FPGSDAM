/*
* Copiar la cadena a otra, de manera que quede al recves 
*/

package EVALUACION1.clase;

public class Ej76 {

	public static void main(String[] args) {
		
		char[] frase = {'u','n','p','e','r','r','o','u','n','g','a','t','o','u','n','t','u','r','o'}; 
		char[] cadena = new char[150];
		cambianeitor(frase, cadena);
		System.out.println(cadena);

	}

	public static void cambianeitor(char[] molde, char[] destino) {
		for (int i = molde.length - 1/*,j*/; i >= 0; --i/*,++j*/){
			destino[molde.length - i - 1/*o cambiarlo por j*/] = molde[i];
		}
	}

}
