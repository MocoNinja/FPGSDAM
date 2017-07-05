/*
* Tenemos una frase
* En otra cadena nueva (de memoria alocada), tenemos que copiarla 2 veces
*/
package EVALUACION1.clase;

public class Ej75 {

	public static void main(String[] args) {
		
		char[] frase = {'u','n','p','e','r','r','o','u','n','g','a','t','o','u','n','t','u','r','o'}; 
		int veces = 6;
		char[] cadena = new char[150];
		meteneitor(frase, cadena, veces);
		System.out.println(cadena);
		
	}
	
	public static void meteneitor (char[] molde, char[] destino, int veces){
		int indice = 0;
		for (int i = 1; i <= veces; ++i){
			for (int j = 0; j < molde.length; ++j, indice++){
				destino[indice] = molde[j];
				//indice++;
			}
			if (i != veces){
				destino[indice] = ' ';
				indice++;
			} 
		}
	}
	

}
