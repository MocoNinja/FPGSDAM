package mio_estudiar;

public class CadenasCaracteresSustiuyeSubcadenas {
	
	public static void main(String[] args) {
		
		char[] frase = {'E', 'j', 'e', 'm','e', 'm', 'p', 'l', 'o', ' ','e', 'm', '1', ' ', 'f', 't', 'w'};
		char[] entrada = {'e', 'm'};
		char[] sustituto = {'i','m','o'};
		System.out.println(detectaPosicionesSubcadena(frase, entrada, sustituto));
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
	
	public static char[] detectaPosicionesSubcadena(char[] frase, char[] caracteres, char[] nuevos){
		
		boolean coincide = false;
		char[] nuevaFrase = new char[100];
		int indice = 0;
			for (int i = 0; i < frase.length; i++, indice++){
				if( i != frase.length - 1 && frase[i] == caracteres[0]){
					coincide = coincidir(frase, caracteres, i+1);
					if (coincide){
						for (int j = 0; j < nuevos.length; j++, indice++){
							nuevaFrase[indice] = nuevos[j];
						}
						indice--;
						i += caracteres.length - 1;
					} else{
						break;
					}
						
				} else {
					nuevaFrase[indice] = frase[i];
				}
			}
			
	return nuevaFrase;
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