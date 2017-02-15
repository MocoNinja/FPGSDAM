package mio_clase;
/*
* Tenemos un String, un valor de inicio y otro de fin
* Mostar por pantalla los caracteres que hay entre esas posiciones
*/

/*
* Funcion	subString: devuelve como String
* http://docs.oracle.com/javase/7/docs/api/java/lang/String.html
*/
public class FuncionesStrings1 {

    public static void main(String[] arg) {
    	String frase = "Hola hola hola, qué pasa muchachos!!!";
    	int inicio = 0;
    	int fin = 9;
    	String busqueda = frase.substring(inicio, fin);
    	System.out.println(busqueda);
    }
    
}