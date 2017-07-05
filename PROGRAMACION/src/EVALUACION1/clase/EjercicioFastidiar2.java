package EVALUACION1.clase;

/*
* Vector de Strings como el de antes
* Reemplazamos un substring por otro
* El otro es el a sustituir, pero en mayúsculas
*/

public class EjercicioFastidiar2 {

    public static void main(String[] args) {
    	String[] vector = {"Pepe y Pepa se cayeron de la motocicleta y tienen el cráneo roto", "Culo roto", "Almería no mola tanto como Zaragozá", "Asno", "Azotaina", "Imperio otomano", "Eres un máquina troncazo!"};
    	String subCadena = "oto";
    	/*
    	for (int i = 0; i < vector.length; i++){
    		for (int j = 0; j < vector[i].length(); j++){
    			if (j == vector[i].indexOf(subCadena)){  //OJO QUE ES UN PUTO PARENTESIS!!!!!!
    				//System.out.printf("Subcadena encontrada en la palabra %d, en la posicion %d%n", i, j);
    				vector[i] = vector[i].replace(subCadena,subCadena.toUpperCase());
    			}
    		}
    	}
    	*/
    	for (int i = 0; i < vector.length; i++){
    		vector[i] = vector[i].replace(subCadena,subCadena.toUpperCase());
    	}
    	for (int i = 0; i < vector.length; i++){
    		System.out.println(vector[i]);
    	}
    }
 }