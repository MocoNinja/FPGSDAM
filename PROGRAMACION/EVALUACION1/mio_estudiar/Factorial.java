package mio_estudiar;

public class Factorial {

	public static void main(String[] args) {
		
		int numero = 5;
		
		System.out.println("El factorial de " + numero + " es: " + factorialNoRecursivo(numero));
		
		System.out.println("El factorial de " + numero + " es: " + factorialRecursivo(numero));
	}
	
	public static int factorialNoRecursivo(int numero){
		int resultado = numero;
		for (int i = numero - 1; i >=2; i--){
			resultado *= i;
		}
	return resultado;
	}
	
	public static int factorialRecursivo(int numero){
		if (numero == 2){
			return 2;
		} else {
			return numero*factorialRecursivo(numero - 1);
		}
	}

}
