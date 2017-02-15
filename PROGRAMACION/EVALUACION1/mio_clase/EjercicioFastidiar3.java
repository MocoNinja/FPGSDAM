package mio_clase;
/*
* Tenemos un String que son palabras separadas por espaciosy que acaba en un espacio
* Hay que quitar la ultima letra de cada palabra
*/

public class EjercicioFastidiar3 {

    public static void main(String[] args) {
    	String palabra = "Don pito pocho ";
/*
    	// Mi método inicial
     	int i = 0;
    	while (i < palabra.length()){ 
    		//System.out.printf("He leído %c%n", palabra.charAt(i));
    		if (palabra.charAt(i) == ' '){
    			//System.out.println("Hay un espacio");
    			comienzo = i;
    			palabra = palabra.replace(palabra.substring(0, comienzo),palabra.substring(0, comienzo - 1));
    		}
    		i++;
    	}
    	System.out.println(palabra);
*/
    	
    	//repetir usando index of para hacer menos iteraciones
    	int posicion = 0;
    	//for (int i = 0; i < 3; i++){
    	while (palabra.indexOf(' ', posicion + 1) != -1){
    		posicion = palabra.indexOf(' ', posicion + 1);
    		//System.out.println(posicion);
    		palabra = palabra.replace(palabra.substring(0, posicion),palabra.substring(0, posicion - 1));
    		//System.out.println(palabra);
 	
    	}
    		
    	System.out.println(palabra);
    }
    
    /*
     
					░░░░░░░█�?▓▓░████▄▄▄█▀▄▓▓▓▌█ 
					░░░░░▄█▌▀▄▓▓▄▄▄▄▀▀▀▄▓▓▓▓▓▌█ 
					░░░▄█▀▀▄▓█▓▓▓▓▓▓▓▓▓▓▓▓▀░▓▌█ 
					░░█▀▄▓▓▓███▓▓▓███▓▓▓▄░░▄▓�?█▌ 
					░█▌▓▓▓▀▀▓▓▓▓███▓▓▓▓▓▓▓▄▀▓▓�?█ 
					�?█�?██�?░▄▓▓▓▓▓▀▄░▀▓▓▓▓▓▓▓▓▓▌█▌ 
					█▌███▓▓▓▓▓▓▓▓�?░░▄▓▓███▓▓▓▄▀�?█ 
					█�?█▓▀░░▀▓▓▓▓▓▓▓▓▓██████▓▓▓▓�?█ 
					▌▓▄▌▀░▀░�?▀█▄▓▓██████████▓▓▓▌█▌ 
					▌▓▓▓▄▄▀▀▓▓▓▀▓▓▓▓▓▓▓▓█▓█▓█▓▓▌█▌ 
					█�?▓▓▓▓▓▓▄▄▄▓▓▓▓▓▓█▓█▓█▓█▓▓▓�?█

									WOW
		1 PUNTO M�?S EN LA EVALUACIÓN ME DEBES AGUST�?N!!!!!11!!!
     */
}
    
    