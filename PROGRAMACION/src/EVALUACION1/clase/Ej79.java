package EVALUACION1.clase;

/*
* Sustituir cadena por cadena  
*/
public class Ej79 {

	public static void main(String[] args) {
		char[] frase = { 'u', 'n', ' ', 'p', 'e', 'r', 'r','o', ' ', 'u', 'n', ' ', 'g', 'a', 't', 'o' };
		char[] cadena = {'u', 'n', ' '};
		char[] sustituto = {'x', 'X', 'x'};
		char[] destino = new char[150];

		
		teacher(frase, cadena, sustituto, destino);
		

	}
	
	public static void teacher(char[] cadena, char[] subcad1, char subcad2[], char cadena2[]){
		int i = 0, j = 0;
		int x, y;
		while(i < cadena.length){
			if (cadena[i] != subcad1[0]){
				cadena2[i] = cadena[i];
				j++;
			} else {
				x = i + 1; //para seguir a subcadena2
				y = 1 + 1; //para seguir a subcadena1
				while((y < subcad1.length) && (subcad1[y] == cadena[x]) ){
					x++;
					y++;
				}
				if (y == subcad1.length)
					System.out.println("Encontrado en la posición " + i);
					for (int k = i; k < subcad2.length; k++){
						cadena2[j] = cadena[k];
					}
			}
			i++;
		}
	}
}
	
	
