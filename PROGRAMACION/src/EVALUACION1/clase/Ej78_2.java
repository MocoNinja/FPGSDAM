package EVALUACION1.clase;

/*
* Cambiar el orden de las palabras (ab cd ef -> ef cd ab) 
*/
public class Ej78_2{

	public static void main(String[] args) {
		
		char[] frase = {' ', 'u','n',' ','p','e','r','r','o',' ', 'u','n',' ','g','a','t','o',' ','u','n',' ','t','o','r','o', ' '}; 
		char[] cadena = new char[150];
		int finalFrase = frase.length - 1;
		int comienzoFrase = finalFrase;
		int indice = 0;
		
		for (int i = frase.length - 1; i >= 0; --i){
			if (frase[i] == ' '){
				comienzoFrase = i + 1;
				for (int j = comienzoFrase; j <= finalFrase; ++j, ++indice){
					cadena[indice] = frase [j];
				}
				finalFrase = comienzoFrase - 1;
				comienzoFrase = finalFrase;
			}
		}
		System.out.println(cadena);

	}

}
