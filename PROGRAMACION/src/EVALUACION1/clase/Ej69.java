package EVALUACION1.clase;

/*
* Otro ejercicio de sustitucion
* Un caracter sera cambiado por un vector de 2 caracteres
*/

public class Ej69 {

	public static void main(String[] args) {
		char[] frase = new char[100];
		char[] letras = {'1', '2', '3', '4', '5', '2'};
		char sustituir = '2';
		char[] sustituto = {'x', 'z'};
		for (int i = 0; i < letras.length; ++i)
			frase[i] = letras[i];
		sustituirCaracteres(frase, letras, sustituir, sustituto);
		//sustitucionTeacher(frase, sustituir, sustituto, letras.length);
		System.out.println(frase);
		//System.out.println(frase.length);
	}
	
	public static void sustitucionTeacher(char fr[], char s1, char[] s2, int longitud){
		for (int i = 0; i < longitud; ++i)
			if(fr[i] == s1){
				for (int j = longitud - 1; j >= i; j--)
					fr[j + 1] = fr[j];
				longitud ++;
				fr[i] = s2[0];
				//fr[i + 1] = s2[1];
				/*
				* Post incrementar: asignar y sumar
				* Pre incrementar: sumar y asignar
				*/
				fr[++i] = s2[1];
			}	
	}
	
	public static void sustituirCaracteres(char[] vector, char[] referencia, char c1, char[] c2){
		int sustituciones = 0;
		for (int i = referencia.length - 1; i >= 0; i--){ //Recorre los elementos llenos inicialmente
		/*for (int i = 0; i < referencia.length; i++){*/
			if (vector[i] == c1){ //Si hay que sustituir el elemento
				for (int j = referencia.length - 1 + sustituciones; j >= i; --j){ //Desplaza hacia la dcha desde ahi al final 
					vector[j + 1] = vector[j];
				}
				for (int z = 0; z < c2.length; z++){ // Sustituye por todos los elementos del vector de sustitucion
					vector[i + z] = c2[z];
				}
				sustituciones ++; //El nuevo vector es mas largo -> empezar a desplazar mas lejos
			}
		}
	}
	
}
