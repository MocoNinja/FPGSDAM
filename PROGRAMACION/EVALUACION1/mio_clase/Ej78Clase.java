package mio_clase;

public class Ej78Clase {

	public static void main(String[] args) {
		
		char[] frase = {' ', 'F', 'r','a','s', 'e', ' ','d','e',' ', 'c', 'o', 'ñ', 'a', ' ', 'j', 'u', 'a', 's', ' ', 'x', '3'};
		char[] cadena2 = new char[150];
		int fin = frase.length - 1;
		int inicio = fin;
		int indice = 0;
		
		//for (int i = frase.length - 1; i >= 0; i--){ //MIERDA
		while (inicio > 0){
			while (/*inicio >= 0 &&  PUTA MIERDA*/frase[inicio] != ' ')
				inicio--;
		
			for (int j = inicio + 1; j <= fin; j++, indice++)
				cadena2[indice] = frase[j];
			
			inicio = fin = inicio - 1;
			
			if (inicio != 0){
				cadena2[indice] = ' ';
				indice++;
			}
	
		}
		System.out.println(cadena2);
	}

}
