package EVALUACION1.clase;

/*Divisiones enteras mediante restas
*
* 13 : 3 = 4
*
* 13 - 3 = 10; 1 vez
* 10 - 3 = 7;  2 veces
* 7 - 3 = 4;   3 veces
* 4 - 3 = 1;   4 veces
*
*/

public class Ej13{
	public static void main(String arg[]){
		final int dividendo = 233245; //Puedo dejar esto no final y ahorrarme la variable i
		final int divisor = 340;
		int resultado = 0;
/* 				//Lo he hecho guay, pero lo ha puesto para explicar el while		
		for (int i = dividendo; (i - divisor) >= 0; i -= divisor){
			resultado ++;
		}
*/		if (dividendo < 0 || divisor <= 0){
			System.out.println("Paf. Errorazo");
			return;
		}
		int i = dividendo;
		while((i - divisor) >= 0){  //OJO. ESTO ES EQUIVALENTE A DECIR I > DIVISOR, QUE ES MUCHO MAS ELEGANTE
			resultado ++;
			i -= divisor;
		}
		/*Me da que son exactamente iguales, en plan que compila a lo mismo*/
		System.out.printf("%d / %d = %d\n", dividendo, divisor, resultado);
	}
}