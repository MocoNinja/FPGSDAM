package EVALUACION1.rehechoRepaso;

public class StringReplazaSubcadenas {

	public static void main(String[] args) {

		String frase = "Hola hola hola, qué pasa figurasadsdsdasa??????";
		String subcadena = "asa";
		String replazo = subcadena.toUpperCase();
		
		int indice = frase.indexOf(subcadena, 0);
		while (indice != -1){
			//frase.replace(subcadena, replazo); NO PORQUE LAS STRING SON INMUTABLES
			frase = frase.replace(frase.substring(0, indice), frase.substring(0, indice));
			indice = frase.indexOf(subcadena, indice + 1);
			System.out.println(indice);
		}
		System.out.println(frase);
		
		
		// VECTORES
		
		String[] vector = {"Pepe y Pepa se cayeron de la motocicleta y tienen el cráneo roto", "Culo roto", "Almería no mola tanto como Zaragozá", "Asno", "Azotaina", "Imperio otomano", "Eres un máquina troncazo!"};
    	subcadena = "oto";
    	for (int i = 0; i < vector.length; i++){
    		vector[i] = vector[i].replace(subcadena,subcadena.toUpperCase());
    	}
    	for (int i = 0; i < vector.length; i++){
    		System.out.println(vector[i]);
    	}
    	
	}

}
