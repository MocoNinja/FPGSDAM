package EVALUACION1.rehechoRepaso;

public class StringQuitaLetrasaAntesEspacios {

	public static void main(String[] args) {
		
		String palabra = "Don pito pocho ";
		int indice = palabra.indexOf(' ');
		while (indice != -1){
			palabra = palabra.replace(palabra.substring(0, indice), palabra.substring(0, indice - 1));
			indice = palabra.indexOf(' ', indice + 1);
		}
		System.out.println(palabra);
		
		anade();
	}
	
	public static void anade(){
		String palabra = "Don pito pocho ";
		int indice = palabra.indexOf(' ');
		while (indice != -1){
			palabra = palabra.replace(palabra.substring(0, indice), (palabra.substring(0, indice - 1)+"imbecil"));
			indice = palabra.indexOf(' ', indice + 1);
		}
		System.out.println(palabra);
	}

}
