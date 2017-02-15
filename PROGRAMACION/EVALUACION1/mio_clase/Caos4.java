package mio_clase;

public class Caos4 {

	public static void main(String[] args) {
		String frase = "Había   una    vez";
		String frase1 = "Había   una    vez";
		//yop(frase);
		//profe(frase);
		System.out.println(frase1.replaceAll(" +"," "));
	}
	
	public static void profe(String frase){
		int i = 0;
		boolean primero = true;
		while (i < frase.length()){
			if (frase.charAt(i) == ' '){
				if (primero){
					primero = false;
					i++;
				} else {
					frase = frase.substring(0, i).concat(frase.substring(i + 1, frase.length()));
				} 
			} else {
				i++;
				primero = true;
			}
		}
		System.out.println(frase);
	}
	
	public static void yop(String frase){
		int i = 1;
		boolean primero = true;
		while (i < frase.length()){
			primero = (frase.charAt(i) == ' ' && frase.charAt(i - 1) != ' ');
			if (!primero && frase.charAt(i) == ' '){
				frase = frase.substring(0, i).concat(frase.substring(i + 1, frase.length()));
			} else {
				i++;
			}
		}
		System.out.println(frase);
	}
	
}
