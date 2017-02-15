package mio_clase;

public class Recursividad {

	private static void ejecucionesViejas() {
		System.out.println(factorial(5));
		System.out.println(multiplicar(1, 4000)); // 40000 da StackOverflow
	}

	public static int factorial(int n) { // repaso propio + sabiduría de Agustín
		// int factorial = n;
		if (n == 1) {
			// factorial *= 1;
			return 1;
		} else {
			// factorial *= factorial (n-1);
			return n * factorial(n - 1);
		}
	}

	public static void main(String[] args) {
		//ejecucionesViejas();
		//mostrarFrase(5);
		//int contador = 0;
		//System.out.println(division(7, 2, contador));
		System.out.println(divisionProfe(6, 2));
	}

	public static void mostrarFrase(int a) { // Para Pensar
		if (a > 0) {
			System.out.println("mostarFrase(" + a + ")");
			mostrarFrase(a - 1);
			System.out.println("mostarFrase(" + a + ")");
		}
	}

	public static int multiplicar(int a, int b) { // clase
		if (b == 1) {
			return a;
		} else {
			return a + multiplicar(a, b - 1);
		}
	}

	public static int division(int a, int b, int contador){
		/*
		* 7 / 2 = 3 porque 
		* 7 - 2 = 5; div = 1;
		* 5 - 2 = 3; div = 2;
		* 3 - 2 = 1; div = 3;
		* 1 > 3 -> break(); 
		*/
		if (a > b){
			contador++;
			return division(a - b, b, contador);
		}
	return contador;
	}
	
	public static int divisionProfe(int a, int b){
		if (a < b)
			return 0;
		else
			return (1 + (divisionProfe(a-b, b)));
	}
	
}
