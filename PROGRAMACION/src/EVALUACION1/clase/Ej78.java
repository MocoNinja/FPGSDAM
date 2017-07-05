package EVALUACION1.clase;

/*
* Cambiar el orden de las palabras (ab cd ef -> ef cd ab) 
*/
public class Ej78 {

	public static void main(String[] args) {
		
		char[] frase = {' ','u','n',' ','p','e','r','r','o',' ', 'u','n',' ','g','a','t','o',' ','u','n',' ','t','u','r','o'}; 
		char[] cadena = new char[1500];
		int finalFrase = frase.length - 1;
		int comienzoFrase = finalFrase;
		int indice = 0;
		
		for (int i = frase.length - 1; i >= 0; --i){
			if (frase[i - 1] == ' '){
				comienzoFrase = i;
				for (int j = comienzoFrase; j <= finalFrase; ++j, ++indice){
					cadena[indice] = frase [j];
				}
				//cadena[indice + 1] = ' ';
				//indice += 2;
				finalFrase = comienzoFrase - 1;
				i = finalFrase;
				comienzoFrase = finalFrase;
			}
		}
		System.out.println(cadena);

	}

}
