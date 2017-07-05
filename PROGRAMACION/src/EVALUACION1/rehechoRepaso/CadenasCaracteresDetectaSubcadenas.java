package EVALUACION1.rehechoRepaso;

public class CadenasCaracteresDetectaSubcadenas {

	public static void main(String[] args) {
		
		char[] frase = {'E', 'j', 'e', 'm','e', 'm', 'p', 'l', 'o', ' ','e', 'm', '1', ' ', 'f', 't', 'w'};
		char[] entrada = {'e', 'm'};
		
		//System.out.println(detectaVecesSubcadena(frase, entrada));
		TablaLeer.leerVectorEntero(detectaPosicionesSubcadena(frase, entrada));
	}
	

	
	public static int detectaVecesSubcadena(char[] frase, char[] caracteres){
		
		boolean coincide = false;
		int coincidencias = 0; 
		
		for (int i = 0; i < frase.length; i++){
			
			if( i != frase.length - 1 && frase[i] == caracteres[0]){
				coincide = coincidir(frase, caracteres, i+1);
				if (coincide){
					coincidencias++;
				} else {
				break;
				}
			}
		}
	return coincidencias;
	}
	
	public static int[][] detectaPosicionesSubcadena(char[] frase, char[] caracteres){
		
		boolean coincide = false;
		int[][] posiciones = new int[detectaVecesSubcadena(frase, caracteres)][2];
		int veces = detectaVecesSubcadena(frase, caracteres);
		int indice = 0;
			for (int z = 0; z < veces; z++){
				for (int i = indice; i < frase.length; i++){
					if( i != frase.length - 1 && frase[i] == caracteres[0]){
						coincide = coincidir(frase, caracteres, i+1);
						if (coincide){
							posiciones[z][0] = i;
							posiciones[z][1] = i + caracteres.length - 1;
							indice = posiciones[z][1] + 1;
							break;
						} else {
						break;
						}
					}
				}
			}
	return posiciones;
	}
	
	public static boolean coincidir(char[] texto, char[] referencia, int posicion){
		int coincidencias = 1;
		int indiceMain = posicion;
		int indiceSecond = 1;
		while (indiceSecond < referencia.length && texto[indiceMain] == referencia[indiceSecond]){
			coincidencias++;
			indiceMain++;
			indiceSecond++;
		}
		
		if (coincidencias == referencia.length){
			return true;
		} else {
			return false;
		}		
	}

}