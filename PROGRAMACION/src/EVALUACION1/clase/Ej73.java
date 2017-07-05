package EVALUACION1.clase;

/*
* El ejercicio 71, pero más sencillo
*/

public class Ej73 {

	public static void main(String[] args) {
		char[] frase = {'u','n','p','e','r','r','o','u','n','g','a','t','o','u','n','t','u','r','o'}; // 19
					  /* 0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  10, 11, 12, 13, 14, 15, 16, 17, 18 */
		char[] subCad1 = {'o'}; // 2
		char[] subCad2 = {'b','a','n','a','n','o'};
		char[] cadena = new char[150];
		int i = 0;
		int ascribir = 0;
		int indice;
		while (i < frase.length){
			indice = 1;
			if (frase[i] != subCad1[indice - 1]){ //Si no coincide, mete tal cual
				//System.out.println(cadena);
				cadena[ascribir] = frase[i];
				ascribir++;
				i++;
			} else { //Si no, es que coincide. Primero, hay que meterlo igual...
				//System.out.println("Coincidencia encontrada. Pasando por ahora...");
				while (indice < subCad1.length && frase[indice + i] == subCad1[indice]){//Ahora hay que comprobar que sigue coincidiendo la cadena entera o si es solo una letra puntual la que entra al bucle 
					indice++;
				}
				if (indice == subCad1.length){ //ha coincidido: metemos la subcadena
					for (int j = 0; j < subCad2.length; j++, ascribir++){
						cadena[ascribir] = subCad2[j];
					}
					i += subCad1.length - 1; //ojito
				} else { //ha fallado: metemos la letra que habia
					cadena[ascribir] = frase[i];
					ascribir++;
				}
				i++;
			}
		}
		System.out.println(cadena);
	}

}
