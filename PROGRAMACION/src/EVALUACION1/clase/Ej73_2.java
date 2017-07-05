package EVALUACION1.clase;

/*
* Poner el primero al final y mover todo a la izquierda lugar -> ugarl
* Luego a la derecha lugar rluga
*/
public class Ej73_2{

	public static void main(String[] args) {
		
		char[] palabra = {'E','n',' ','u','n',' ', 'l','u','g', 'a', 'r'};
		//char[] palabraProfesor = {'E','n',' ','u','n',' ', 'l','u','g', 'a', 'r',' '};
						/* 0,  1,  2,  3,  4,  5, '6', '7','8', '9', '10'*/
		int[] posiciones = {-1, 0};

		for (int i = 0; i < detectaPalabras(palabra); ++i){
			posiciones = detectaPosiciones(palabra, posiciones[0] + 1);
			//Funciones.muestraVectorEnteros(posiciones); //Las detecta bien, pero no si se ejecuta la funcion de desplazar
			//System.out.println(palabra);
			//desplazaLetrasIzq(palabra, posiciones);
			desplazaLetrasDch(palabra, posiciones);
			//System.out.println(palabra);
		}
		
		System.out.println(palabra);


	}

	public static int detectaPalabras(char[] vector){
		int palabras = 1;
		for (int i = 0; i < vector.length; ++i){
			if (vector[i] == ' '){
				palabras++;
			}
		}
	return palabras;
	}

	public static int[] detectaPosiciones(char[] vector, int inicio){
		int[] posiciones = {inicio, 0};
		int concurrencias = 0;
		
		for (int i = inicio; i < vector.length - 1; ++i){
			
			if (i == 0){
				posiciones[0] = i;
				concurrencias++;
			}
			
			if (concurrencias == 0 && vector[i] == ' '){
				posiciones[0] = i + 1;
				concurrencias++;
				i++;
			}
			
			if (concurrencias == 1 && vector[i + 1] == ' '){
				posiciones[1] = i;
				break;
				/*Si se desea no usar break, puede devolverse aquí el vector*/
			}
			posiciones[1] = vector.length - 1; //Esto detecta la última letra del vector
		}
	return posiciones;
	}
	
	public static void desplazaLetrasIzq(char[] vector, int[] posiciones){
		char aux = vector[posiciones[0]];
		int indice = posiciones[0] + 1;
		while (indice <= posiciones[1]){
			vector[indice - 1] = vector[indice];
			indice ++;
		}
		vector[posiciones[1]] = aux;
	}

	public static void desplazaLetrasDch(char[] vector, int[] posiciones) {
		
		char aux = vector[posiciones[1]];
		int indice = posiciones[1];
		while (indice > posiciones[0]){
			vector[indice] = vector[indice - 1];
			indice --;
		}
		vector[posiciones[0]] = aux;
		
	}
	
}