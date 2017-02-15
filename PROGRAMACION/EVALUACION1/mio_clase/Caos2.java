package mio_clase;

/*
* Poner la frase al reves (ab cd --> dc ba)
* ej1: sobre otra frase
*/


public class Caos2 {

	public static void main(String[] args) {

		String frase1 = "Eviscera al proletariado";
		String frase2 = "";
	
		for (int i = frase1.length() - 1; i >= 0; i--){
			frase2 += frase1.charAt(i);
			//frase2 = frase2.concat(Character.toString(frase1.charAt(i)));
		}
		System.out.println(frase2);
		
	}

}
