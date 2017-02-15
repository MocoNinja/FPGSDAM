package mio_clase;

/*
* Los dos de antes, combinados en 1 
*/
public class Ej77 {

	public static void main(String[] args) {

		char[] frase = {'u','n','p','e','r','r','o','u','n','g','a','t','o','u','n','t','u','r','o'}; 
		//int veces = 2;
		char[] cadena = new char[150];
		normaleitor(frase, cadena);
		System.out.println(cadena);

	}
	
	public static void normaleitor(char[] molde, char[] destino){
		int indice = 0;
		
		for (int j = 0; j < molde.length; ++j, indice++)
			destino[indice] = molde[j];
		indice++;
		destino[indice] = ' '; 
		indice ++;
		for (int z = molde.length - 1; z >= 0; --z, indice++)
			destino[indice] = molde[z];
		
	}
	
	
	
	/*
	public static void meteneitor (char[] molde, char[] destino){
		int indice = 0;
		
		for (int i = 1; i <= veces; ++i){
			if ((veces % 2) != 0){ //si es impar (vez 1, 3, 5...), mete tal cual
				for (int j = 0; j < molde.length; ++j, indice++){
					destino[indice] = molde[j];}
				if (i != veces){
					destino[indice] = ' ';
					indice++;
				} 
				
			} else { //si es par, inviertela
				
				for (int z = molde.length - 1; z >= 0; --z, indice++){
					destino[indice] = molde[z];
				}
			}
		}
	}
	*/
}
