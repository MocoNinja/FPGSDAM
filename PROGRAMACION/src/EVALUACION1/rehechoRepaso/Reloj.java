package EVALUACION1.rehechoRepaso;

public class Reloj {

	public static void main(String[] args) {
		
		int hora = 13; /*Puede ir de 1 a 24*/
		int campanadas = 0;
		
		if (hora > 12){
			hora -= 12;
			for (int i = 1; i < 12; i++){
				campanadas += i;
			}
		}
		
		for (int i = hora; i <= 12; i++){
			campanadas += i;
		}
		System.out.println(campanadas);
	}
}
