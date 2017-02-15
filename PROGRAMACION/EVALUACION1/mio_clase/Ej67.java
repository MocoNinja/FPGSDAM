package mio_clase;

/*
*
*/
public class Ej67 {

	public static void main(String[] args) {
		char[]  frase = {'E', 'j', 'e', 'm', 'p', 'l', 'o', ' ', '1', ' ', 'f', 't', 'w'};
		vectorMay(frase);
		System.out.println(frase);
	}
	
	public static void vectorMay(char[] vector){
		for (int i = 0; i < vector.length; ++i)
			vector[i] = Character.toUpperCase(vector[i]);
	}
}
