package EVALUACION1.examen;


public class Ejercicio3 {

	public static void main(String[] args) {
		
		String frase = "En_un_lugar_de_La_Mancha____________________________________________________________________________";
		char[] destino = new char[100];
		cargaChar(frase, destino);
		System.out.println(destino);
		int numeroPalabras = detectaPalabras(destino);
		//System.out.println(detectaPalabras(destino));
		int[] caracteres = detectaCaracteres(destino);
		//System.out.printf("Eso son %d letras y %d espacios...%n", caracteres[0], caracteres[1]);
		int espaciosPorFrase = caracteres[1]/numeroPalabras;
		justificaFrase(destino, espaciosPorFrase);
		
		

	}
	
	public static void justificaFrase(char[] frase, int espaciosPorFrase){
		String palabraJustificada = "";
		String espacioAIntroducir = fraseMultiplicada(" ", espaciosPorFrase);
		for (int i = 0; i < frase.length; i++){
			if (frase[i] != ' '){
				palabraJustificada += frase[i];
			} else {
				palabraJustificada += espacioAIntroducir;
			}
		}
		System.out.println(palabraJustificada);
	}
	
	// Este método me permite meter el char más rapido
	public static void cargaChar(String string, char[] destino){
		for (int i = 0; i < destino.length; i++){
			if(string.charAt(i) != '_'){
				destino[i] = string.charAt(i);
			} else {
				destino[i] = ' ';
			}
			
		}
	}
	
	//Cuántas palabras hay
	public static int detectaPalabras(char[] destino){
		int palabras = 1;
		for (int i = 0; i < destino.length - 1; i++){
			if ((destino[i] == ' ') && (destino[i + 1] != ' ')){
				palabras++;
			}
		}
	return palabras;
	}
	
	//Cuantos caracteres tiene y cuantos espacios
	public static int[] detectaCaracteres(char[] destino){ //Devuelve {i, j}, siendo i los no espacios y j los espacios
		int[] caracteres = {0,0};
			for (int i = 0; i < destino.length; i++){
				if (destino[i] == ' '){
					caracteres[1]++;
				} else {
					caracteres[0]++;
				}
			}
	return caracteres;
	}
	
	public static String fraseMultiplicada(String frase, int veces){
		String resultado = "";
		for (int i = 0; i < veces; i++){
			resultado += frase;
		}
	return resultado;
	}

}
