package EVALUACION1.clase;

public class Caos5ConCambios {

	public static void main(String[] args) {
		String frase = "Vamos a pencar todos!!! muy mucho";
		String frase1 = "";
		String frase2 = "";
		int inicio = 0;
		int fin = 0;
		int contador = 0;
		int i = 0;
		do{
			if (frase.charAt(i) == ' ' ||  i == frase.length() - 1){
				fin = i + 1;
				if (contador % 2 == 0) {
					frase1 += frase.substring(inicio, fin);
				} else {
					frase2 += frase.substring(inicio, fin);
				}
				contador++;
				inicio = i + 1;
			}
			i++;
		}
		while(i < frase.length());
		System.out.println(frase1);
		System.out.println(frase2);
	}

}
