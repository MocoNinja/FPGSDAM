package mio_clase;
/*
* Funcion String.replace('caracterasustiruir', 'caracterqueremplaza')
* http://docs.oracle.com/javase/7/docs/api/java/lang/String.html#replace
* http://docs.oracle.com/javase/7/docs/api/java/lang/String.html#indexof
*/
public class FuncionesStrings3 {

    public static void main(String[] args) {
    	
    	String frase = "Hola hola hola, qué pasa figurasadsdsdasa??????";
    				/*  01234567890123456789012345678901234567890123456  */
    				/*			  1			2		  3         4		 */
/*
    	System.out.printf("%s%n", frase.replace('a', 'X'));
    	System.out.printf("%s%n", frase.replace("hola", "frambuesa"));
    	System.out.printf("asa está a partir de la posición %d %n", frase.indexOf("asa"));
*/  	
    	/* Ahora lo que queremos programar, usando estas funciones, es una función que nos saque TODAS las posiciones */
 /*
    	for (int i = 0; i <= frase.length(); i++ ){
    		if (i == frase.indexOf("asa", i)) //Definición: esta funcion es polimorfa porque tiene varias formas: la que tiene un String, y la que tiene un String y un entero
    			System.out.printf("La subcadena 'asa' aparece en la posición %d%n", i);
    	}
*/
/*
    	int i = 0;
    	// After teacher's wisdom
    	while (frase.indexOf("asa", i) > 0){
    		if (i == frase.indexOf("asa", i)) //Definición: esta funcion es polimorfa porque tiene varias formas: la que tiene un String, y la que tiene un String y un entero
    			System.out.printf("La subcadena 'asa' aparece en la posición %d%n", i);
    		i++;
    	}
*/ 	
    	// Teacher's Wisdom
    	int cont = 0;
    	int j = frase.indexOf("asa", 0);
    	while (j != -1){
    		cont++;
    		System.out.printf("Aparece por vez numero %d en la posicion: %d.%n",cont, j);
    		j = frase.indexOf("asa", j + 1);
    	}
		System.out.printf("Ha aparecido %d veces.%n",cont);
    }
}