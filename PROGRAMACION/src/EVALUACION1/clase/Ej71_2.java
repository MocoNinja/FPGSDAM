package EVALUACION1.clase;

/*
* 2 subcadenas de caracteres
* Sustituir una por la otra
* Hacerlo con una funcion que devuelve la posicion a partir de la cual se encuentre la subcadena
* Otra funcion que introduzca la cadena nueva
*/
public class Ej71_2{

	public static void main(String[] args) {
		char[] frase = {'u','n','p','e','r','r','o','u','n','g','a','t','o','u','n','t','u','r','o'}; // 19
					  /* 0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  10, 11, 12, 13, 14, 15, 16, 17, 18 */
		//char[] subCad1 = {'u','n'}; // 2
		char[] subCad1 = {'u', 'n'}; // 2
		char[] subCad2 = {'b','a','n','a','n','o'};
		//char[] subCad2 = {'a', 'n', 'o'};
		//char[] cadena2 = new char[100];
		char[] cadena2 = new char[frase.length + cuentaSubcadenas(frase, subCad1)*(subCad2.length - subCad1.length)]; //Autismo
		int[] posiciones = new int[cuentaSubcadenas(frase, subCad1)]; //crea un vector para almacenar las posiciones de las subcadenas
		/* { 0, 7, 13} */
		int indice = -1; //AsÃ­ empieza a buscar desde 0 y luego desde el siguiente al Ã­ndice que haya encontrado
		
		//Search
		
		for (int i = 0; i < posiciones.length; ++i){
			posiciones[i] = detectaSubcadenas(frase, subCad1, indice + 1);
			indice = posiciones[i];
		}
		
		//&&
		
		//Destroy
		
		cambianeitor(frase, cadena2, subCad2, posiciones);
		
		System.out.println(cadena2);
		
	}
	
	public static int cuentaSubcadenas(char[] palabra, char[] texto){
		
		int veces = 0;
		int coincidencias;
		
		for (int i = 0; i < palabra.length - texto.length + 1; ++i){ // 0 <= i <= 17
			//System.out.println(palabra[i]);
			coincidencias = 0;
			if (palabra[i] == texto[0]){
				coincidencias++;
				//System.out.println("Detectada primera coincidencia.");
				int j = 1;
				while ((j < texto.length) && (palabra[i + j] == texto[j])){ // 1 <= j <= 2  ==> palabra[1] --> palabra[18]
					coincidencias++;
					j++;
				}
				//System.out.printf("Detectadas %d coincidencias adicionales...%n", j-1);
			}
			if (coincidencias == texto.length){
				veces++;
				i += coincidencias - 1;
			}
		}
	return veces;
	}

	public static int detectaSubcadenas(char[] palabra, char[] texto, int posicion){
		int coincidencias;
		
		for (int i = posicion; i < palabra.length - texto.length + 1; ++i){
			coincidencias = 0;
			if (palabra[i] == texto[0]){
				coincidencias++;
				int j = 1;
				while ((j < texto.length) && (palabra[i + j] == texto[j])){
					coincidencias++;
					j++;
				}
			}
			if (coincidencias == texto.length){
				posicion = i;
				break;
				/* Podemos usar aquÃ­ un return posicion si no se sabe usar el break, pero mejor usarlo que es mÃ¡s bonico */
			}
		}
	return posicion;
	}
	
	public static void cambianeitor(char[] molde, char[] destino, char[] sustituto, int[] objetivos){
		
		int indiceLeido = 0;
		int indiceEscrito = 0;
		for (int i = 0; i < molde.length; ++i){
			if (indiceLeido < objetivos.length && i == objetivos[indiceLeido]){
				for (int j = 0; j < sustituto.length; ++j){
					destino[indiceEscrito] = sustituto[j];
					indiceEscrito++;
				}
				indiceLeido++;
				i++;
				/* AquÃ­ tendrÃ­a que hacer tantos i++ como caracteres menos 1 tenga la cadena a sustituir. No lo he hecho que se me ha pasado y tengo que invocar otro vector. Pero serÃ­a algo asÃ­n: */
				/*i += sustituto.length - 1;*/
			} else {
				destino[indiceEscrito] = molde[i];
				indiceEscrito++;
			}
		}	
	}
	
	
/*
 
 â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–ˆâ–�â–“â–“â–‘â–ˆâ–ˆâ–ˆâ–ˆâ–„â–„â–„â–ˆâ–€â–„â–“â–“â–“â–Œâ–ˆ 
â–‘â–‘â–‘â–‘â–‘â–„â–ˆâ–Œâ–€â–„â–“â–“â–„â–„â–„â–„â–€â–€â–€â–„â–“â–“â–“â–“â–“â–Œâ–ˆ 
â–‘â–‘â–‘â–„â–ˆâ–€â–€â–„â–“â–ˆâ–“â–“â–“â–“â–“â–“â–“â–“â–“â–“â–“â–“â–€â–‘â–“â–Œâ–ˆ 
â–‘â–‘â–ˆâ–€â–„â–“â–“â–“â–ˆâ–ˆâ–ˆâ–“â–“â–“â–ˆâ–ˆâ–ˆâ–“â–“â–“â–„â–‘â–‘â–„â–“â–�â–ˆâ–Œ 
â–‘â–ˆâ–Œâ–“â–“â–“â–€â–€â–“â–“â–“â–“â–ˆâ–ˆâ–ˆâ–“â–“â–“â–“â–“â–“â–“â–„â–€â–“â–“â–�â–ˆ 
â–�â–ˆâ–�â–ˆâ–ˆâ–�â–‘â–„â–“â–“â–“â–“â–“â–€â–„â–‘â–€â–“â–“â–“â–“â–“â–“â–“â–“â–“â–Œâ–ˆâ–Œ 
â–ˆâ–Œâ–ˆâ–ˆâ–ˆâ–“â–“â–“â–“â–“â–“â–“â–“â–�â–‘â–‘â–„â–“â–“â–ˆâ–ˆâ–ˆâ–“â–“â–“â–„â–€â–�â–ˆ 
â–ˆâ–�â–ˆâ–“â–€â–‘â–‘â–€â–“â–“â–“â–“â–“â–“â–“â–“â–“â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–“â–“â–“â–“â–�â–ˆ 
â–Œâ–“â–„â–Œâ–€â–‘â–€â–‘â–�â–€â–ˆâ–„â–“â–“â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–“â–“â–“â–Œâ–ˆâ–Œ 
â–Œâ–“â–“â–“â–„â–„â–€â–€â–“â–“â–“â–€â–“â–“â–“â–“â–“â–“â–“â–“â–ˆâ–“â–ˆâ–“â–ˆâ–“â–“â–Œâ–ˆâ–Œ 
â–ˆâ–�â–“â–“â–“â–“â–“â–“â–„â–„â–„â–“â–“â–“â–“â–“â–“â–ˆâ–“â–ˆâ–“â–ˆâ–“â–ˆâ–“â–“â–“â–�â–ˆ

			WOW
		VERY CODE
 */
	
}
