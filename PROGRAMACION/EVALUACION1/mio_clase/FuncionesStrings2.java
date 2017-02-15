package mio_clase;
public class FuncionesStrings2 {

    public static void main(String[] args) {
    	
    	String frase = "Hola hola hola, qué pasa figuras??????";
    	
    	for (int fin = 0; fin <= frase.length(); fin++)
    		System.out.printf("%s%n", frase.substring(0, fin)); /*El en vez de <= pone i + 1*/
    		
    			//FOR FUN
    /*
    	int veces = 100;
    	for (int i = 0; i < veces; i++){
    		for (int fin = 0; fin < frase.length(); fin++){
    		System.out.printf("%s%n", frase.substring(inicio, fin));
    	}
    	for (int fin = frase.length() - 1; fin >= 0; fin--){
    		System.out.printf("%s%n", frase.substring(inicio, fin));
    	}
    	}
    
    */
    }
    
    
}