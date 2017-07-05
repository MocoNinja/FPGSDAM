package EVALUACION1.rehechoRepaso;

public class StringCambiaCapitalizacionVocales {

	public static void main(String[] args) {
		
		String palabra = "En un lugar feo";
		String resultado = "";
		
		for (int i = 0; i < palabra.length(); i++){
			if (esVocal(palabra.charAt(i))){
				resultado += Character.toUpperCase(palabra.charAt(i));
			} else {
				resultado += palabra.charAt(i);
			}
		}
		
		System.out.println(resultado);
	}
	
	public static boolean esVocal(char caracter){
		switch (caracter) {
		case 'a':
			return true;
			
		case 'e':
			return true;
			
		case 'i':
			return true;
			
		case 'o':
			return true;
			
		case 'u':
			return true;
			
		default:
			return false;
		}
	}

}
