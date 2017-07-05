package EVALUACION1.clase;
/*
* Mostrar el vector mostrado multiplicados por los multiplos
* El vector datos NO debe modificarse
* Cada elemento por cada multiplo
*/
public class Ej27{
	public static void main(String arg[]){
		int datos[] = {1, 5, 9, 13};
		int multiplos[] = {128, 256, 512, 1024};
		System.out.printf("\n\n");
		for (int i = 0; i < multiplos.length; ++i){
			System.out.print("[");
			for (int j = 0; j < datos.length; ++j){
				System.out.printf(" %5d ", datos[j]*multiplos[i]);
			}
			System.out.print("]");
			System.out.printf("\n\n");
		}
	}
}