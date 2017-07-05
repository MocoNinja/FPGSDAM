package EVALUACION1.rehechoRepaso;

public class StringsCuentaSubcadenas {

	public static void main(String[] args) {
		
		String frase = "Hola hola hola, qué pasa figurasadsdsdasa??????";
		String subcadena = "asa";
		int veces = 0;
		int j = frase.indexOf("asa", 0);
		while (j != -1){
    		veces++;
    		System.out.printf("Aparece por vez numero %d en la posicion: %d.%n",veces, j);
    		j = frase.indexOf("asa", j + 1);
    	}
		System.out.printf("Ha aparecido %d veces.%n",veces);

	}

}
