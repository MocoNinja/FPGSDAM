package EVALUACION1.clase;
/*
* Vector de Strings
* Contar cuantas veces se encuentra el car�acter 'a'
*/

public class E2{

    public static void main(String[] args) {
    	String[] vector = {"Pepe y Pepa se cayeron de la motocicleta", "Almer�a no mola tanto como Zaragoz�", "Asno", "Azotaina", "Eres un m�quina troncazo!"};
    	int veces = 0;
    	char caracter = 'a';
    	
    	for (int i = 0; i < vector.length; i++){
    		for (int j = 0; j < vector[i].length(); j++){
    			if (vector[i].charAt(j) == caracter){  //OJO QUE ES UN PUTO PARENTESIS!!!!!!!
    				veces++;
    			}
    		}
    	}
    	System.out.printf("%c sale %d veces...", caracter, veces);
    }
 }
    
    