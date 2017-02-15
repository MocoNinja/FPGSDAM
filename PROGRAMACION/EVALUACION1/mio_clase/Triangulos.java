package mio_clase;

public class Triangulos {

	public static void main(String[] args) {
	for (int i = 1; i <= 1000000; ++i)
	dibujaTriangulo(5, '*');

	}
	
	public static String multiplicaChars(char caracter, int veces){
		String resultado = "";
		for (int i = 0; i < veces; i++)
			resultado += caracter;
	return resultado;
	}

	public static void dibujaTriangulo (int lado, char relleno ){
		for (int i = 1; i <= lado; i++)
			System.out.println(multiplicaChars(relleno, i));
		for (int i = lado - 1; i >= 1; i--)
			System.out.println(multiplicaChars(relleno, i));
	}
	
}
