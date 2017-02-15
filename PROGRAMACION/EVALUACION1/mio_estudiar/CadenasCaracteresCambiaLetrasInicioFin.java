package mio_estudiar;

public class CadenasCaracteresCambiaLetrasInicioFin {

	public static void main(String[] args) {
		
		char[] palabra = {' ', 'E','n',' ', 'u','n',' ', 'l','u','g', 'a', 'r'};
		cambia(palabra);
		System.out.println(palabra);
	}

	public static void cambia(char[] palabra){
		int posInicio = palabra.length - 1, posFin = palabra.length - 1;
		int i = posFin;
		char aux = ' ';
		while (i > 0){
			if (palabra[i - 1] != ' '){
				i--;
			} else {
				posInicio = i;
				aux = palabra[posInicio];
				palabra[posInicio] = palabra[posFin];
				palabra[posFin] = aux;
				posFin = i - 2;
				i -= 2;
				posInicio = posFin;
			}
		}
	}
		
}
