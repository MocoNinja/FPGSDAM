package mio_clase;

/*
* Combinaciones de n elemetnos, tomados de m en m
*/

public class Ej58 {

	public static void main(String[] args) {
		int elemento1 = 200;
		int elemento2 = 198;
		if (elemento1 > elemento2)
			System.out.printf("La combinacion de %d elementos, tomados de %d en %d, es %d. %n", elemento1, elemento2, elemento2, combinacionInteligente(elemento1, elemento2));
		else 
			System.out.printf("La combinacion de %d elementos, tomados de %d en %d, es %d. %n", elemento1, elemento2, elemento2, combinacionInteligente(elemento2, elemento1));
	}
	
	public static int factorial(int n){
		int resultado = n;
		if (n == 0)
	return 1;
		for (int i = n - 1; i >= 1; --i){
			//System.out.println("Resultado * i == " + resultado +" * " + i);
			resultado *= i;
			//System.out.println("El resultado es: " + resultado);
		}
	return resultado;
	}
	
	public static int combinacionFuerzaBruta(int mayor, int menor){
		int diferencia = mayor - menor;
		return (factorial(mayor))/(factorial(menor)*factorial(diferencia));
	}
	
	public static int combinacionInteligente(int mayor, int menor){
		/*
		* El cociente entre mayor! y menor! = mayor * mayor -1 * --- * menor + 1 * menor
		*/
		int cocienteFactorial = mayor;
		for (int i = mayor - 1; i > menor; --i){
			cocienteFactorial *= i;
		}
		return cocienteFactorial/(factorial(mayor - menor));
	}
/*
* Autoejercicio:
* Modificar mi combinacionInteligente para que calcule el factorial más pequeño
*/
}
