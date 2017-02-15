package mio_clase;

/*
* EL 71, pero tomando un caracter en vez de una cadena 
*/
public class Ej74 {

	public static void main(String[] args) {
		char[] frase = {'u','n','p','e','r','r','o','u','n','g','a','t','o','u','n','t','u','r','o'}; 
		char caracter = 'n'; 
		char[] sustituto = {'b','a','n','a','n','o'};
		char[] cadena2 = new char[100];
		cambianeitor(frase, cadena2, caracter, sustituto);
		System.out.println(cadena2);
		
	}
	
	
	public static void cambianeitor(char[] molde, char[] destino, char sustituir, char[] sustituto){
		int indice = 0;
		for (int i = 0; i < molde.length; ++i){
			if (molde[i] == sustituir){
				//System.out.println("Detectada coincidencia");
				for (int j = 0; j < sustituto.length; ++j){
					destino[indice] = sustituto[j];
					indice++;
				}
				//indice--;
			} else {
				destino[indice] = molde[i];
				indice++;
			}
			//indice++;
		}
	}

}
