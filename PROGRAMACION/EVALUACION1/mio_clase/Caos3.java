package mio_clase;

/*
* Añadir a a cada pañlabra 
*/

public class Caos3 {

	public static void main(String[] args) {
		String palabra = "Hola, como está usted? ";
		int posicion = 0;
		System.out.println("Hola");
		
    	while (palabra.indexOf(' ', posicion) != -1){
    		posicion = palabra.indexOf(' ', posicion + 1) - 1;
    		palabra = palabra.replace(palabra.substring(0, posicion + 1), (palabra.substring(0, posicion) + "a"));
    		posicion += 2;
    	}
    	
    	System.out.println(palabra);
	}
	
}
