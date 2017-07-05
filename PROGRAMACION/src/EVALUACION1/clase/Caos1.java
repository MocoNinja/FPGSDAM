package EVALUACION1.clase;
/*
* Nivel medio
* Ejercicio típico de char[] pero con Strings
* ej1: con una palabra
* ej2: en una misma palabra
* ej3: independientemente de la longitud
*/
public class Caos1 {

	public static void ej1(){
		String frase1 = "Había vez circo alegraba wwe ";
		String frase2 = "una un que siempre fafaf ";
		String frase3 = "";

		int posicioninicio1 = 0;
		int posicionfinal1 = 0;
		int posicioninicio2 = 0;
		int posicionfinal2 = 0;
		// palabras (frase1) = palabras (frase2); si no, se complica
		//for (int i = 1; i <= 4; i++){//Trampa
		
		while(frase2.indexOf(' ', posicioninicio2 + 1) != -1){
			posicionfinal1 = frase1.indexOf(' ', posicionfinal1);
			frase3 += frase1.substring(posicioninicio1,posicionfinal1);
			if (posicioninicio1 == 0)
				frase3 += " ";
			posicionfinal2 = frase2.indexOf(' ', posicionfinal2);
			frase3 += frase2.substring(posicioninicio2,posicionfinal2);
			posicioninicio1 = posicionfinal1;
			posicionfinal1++;
			posicioninicio2 = posicionfinal2;
			posicionfinal2++;
		} 
		System.out.println(frase3);
	}
	
	public static void ej2(){
		String frase1 = "Había vez circo alegraba wwe ";
		String frase2 = "una un que siempre fafaf ";
		int posicioninicio1 = 0;
		int posicionfinal1 = 0;
		int posicioninicio2 = 0;
		int posicionfinal2 = 0;
		
		while(frase2.indexOf(' ', posicioninicio2 + 1) != -1){
			posicionfinal1 = frase1.indexOf(' ', posicionfinal1);

			if (posicioninicio1 == 0)
				frase1 += " ";
			posicionfinal2 = frase2.indexOf(' ', posicionfinal2);
		
			posicioninicio1 = posicionfinal1;
			posicionfinal1++;
			posicioninicio2 = posicionfinal2;
			posicionfinal2++;
		}

	}
	
	public static void ej3(){
		String frase1 = "Había vez circo alegraba wwe 23";
		String frase2 = "una un que siempre fafaf 534";
		String frase3 = "";

		int posicioninicio1 = 0;
		int posicionfinal1 = 0;
		int posicioninicio2 = 0;
		int posicionfinal2 = 0;
		// palabras (frase1) = palabras (frase2); si no, se complica
		//for (int i = 1; i <= 4; i++){//Trampa
		
		while(frase2.indexOf(' ', posicioninicio2 + 1) != -1 || frase1.indexOf(' ', posicioninicio1 + 1) != -1){
			posicionfinal1 = frase1.indexOf(' ', posicionfinal1);
			frase3 += frase1.substring(posicioninicio1,posicionfinal1);
			if (posicioninicio1 == 0)
				frase3 += " ";
			posicionfinal2 = frase2.indexOf(' ', posicionfinal2);
			frase3 += frase2.substring(posicioninicio2,posicionfinal2);
			posicioninicio1 = posicionfinal1;
			posicionfinal1++;
			posicioninicio2 = posicionfinal2;
			posicionfinal2++;
		} 
		System.out.println(frase3);
	}
	
	public static void main(String[] args) {
		
		
	}
	
	public static void profe(){
		String frase1 = "Había vez circo alegraba wwe 23";
		String frase2 = "una un que siempre fafaf 534";
		String frase3 = "";
		
		int inicio1 = 0;
		int fin1 = frase1.indexOf(" ", 0);
		int inicio2 = 0;
		int fin2 = frase2.indexOf(" ", 0);
		
		while ((fin1 != -1) || (fin2 != -1)){
			if (fin1 != -1){
				frase3 = frase3.concat(frase1.substring(inicio1, fin1).concat(" "));
				fin1 = frase1.indexOf(" ", fin1 + 1);
			}
			if (fin2 != -1){
				frase3 = frase3.concat(frase2.substring(inicio2, fin2).concat(" "));
				fin2= frase2.indexOf(" ", fin2 + 1);
			}
		}
		System.out.println(frase3);
	}
	

}


		 	
		   
