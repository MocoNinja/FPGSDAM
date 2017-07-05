package EVALUACION1.clase;

public class Nuevo4{

/*
* El repite lo de las vocales, y nos dice que miremos el codigo ascii
* 23: retorno de carro
* mayusculas: 65 A, 66 B...
* minusculas: 97 a, 98 b...
*
* A: 65 E: 69  I:73  O:79  U:83
* a: 97 e: 101 i:105 o:111 u:117
*/

/*
* Pasa del ascii y explica el switch
* if: respuesta binaria
* switch: respuesta enearia
* Read: http://stackoverflow.com/questions/5086322/java-switch-statement-multiple-cases
*/
    public static void main(String[] args) {
    	//infoAsci()
    	cambiaVocalesStrings();
    }
    
    public static void infoAsci(){
    	char letra = 0;
    	for (int i = 0; i <= 255; i++)
    		System.out.println("El codigo ascii de la letra '" + letra++ + "' es: " + i);
    }
    
    public static void cambiaVocalesChars(){
    	
	    char[] palabra = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'U', 'n', 'o'};
	    char caracter = '$';
	    	for (int i = 0; i < palabra.length; i++){
	    		switch (palabra[i]){
		    		case 'A':  case 'E':  case 'I':  case 'O':  case 'U':
		    			palabra[i] = Character.toLowerCase(palabra[i]);
		    			break; //Mirar como influye quitar este break;
		    		/*
		    		case 's': //Esto ilustra la importancia de meter el break y sus implicaciones en el flujo
		    			System.out.println("No deberías haber visto esto");
		    		*/
		    		case 'a':  case 'e':  case 'i':  case 'o':  case 'u':
		    			palabra[i] = Character.toUpperCase(palabra[i]);
		    			break; //Mirar como influye quitar este break;
		    		default:
		    			palabra[i] = caracter;
		    			break; //Este break no tiene efecto real;
	    		}
	    	}
	    	System.out.println(palabra);
    }

	public static void cambiaVocalesStrings(){
		String cadena = "En un un lugar de La Mancha, de cuyo nombre no quiero acordarme...";
		char[] palabra = new char[cadena.length()];
		char caracter = '$';
		//System.out.print("'" + cadena +"' cambia a: '");
		/*
	    	for (int i = 0; i < cadena.length(); i++){ //Ojo a la distinción entre la propiedad length y el método length()
	    		System.out.printf(" %c -", cadena.charAt(i)); //Vamos a pensar en esta funcion (más abajo)
	    	}
	    */
	    	for (int i = 0; i < cadena.length(); i++){
	    		palabra[i] = cadena.charAt(i);
	    	}
	    	System.out.println(palabra);
	}

/*
* Cómo sería la funcion charAt()
* public static char charAt(int)
*/
}