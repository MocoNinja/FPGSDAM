package EVALUACION1.rehechoRepaso;

public class FactorialCociente {

	public static void main(String[] args) {
		
		int numero1 = 8;
		int numero2 = 6;
		
		int i = numero2 + 1;
		int cociente = numero1;
		while (i < numero1){
			cociente *= i;
			i++;
		}
		
		System.out.println(cociente);
	}

}
