package EVALUACION1.clase;
public class Ej3{
	public static void main(String arg[]){
		int x = 55;
		int y = 56;
		if (x > y){
			System.out.println(x + " es mayor que " + y);
		} else if (x < y){
			System.out.println(y + " es mayor que " + x);
		} else { /*(x == y)*/
			System.out.println("Son iguales.");
		}
	}
}