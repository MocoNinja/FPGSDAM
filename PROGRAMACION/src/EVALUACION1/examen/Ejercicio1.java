package EVALUACION1.examen;


public class Ejercicio1 {

	public static void main(String[] args) {
		/*
		* Numero decimal a binario
		* Cifra final = numero % 2;
		* Numero /= 2;
		* as� hasta que numero > 1
		*/
		
		int numero = 132;
		System.out.printf("%d en binario es ", numero);
		String binarioReves = "";
		while (numero >=1){
			//System.out.println(numero%2);
			binarioReves += Integer.toString(numero % 2);
			numero /= 2;
			
		}
		String binarioReal = "";
		for (int i = binarioReves.length() - 1; i >= 0; i--){
			binarioReal += binarioReves.charAt(i);
		}
		System.out.printf("'%s'...%n", binarioReal);
	}

}
