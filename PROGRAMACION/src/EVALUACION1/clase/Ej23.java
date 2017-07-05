package EVALUACION1.clase;
/*
* Ejercicio:
* Mostar elementos que superen la media
*/
public class Ej23{
	public static void main(String arg[]){
		double datos[] = {-2, 3, 2, 4};
		double suma = 0; //el usa float
		for (int i = 0; i < datos.length; ++i){
			suma += datos[i];
		}
		double promedio = suma / datos.length;
		for (int i = 0; i < datos.length; ++i){
			if (datos[i] > promedio){
				System.out.printf("%.2f es superior al promedio %.2f\n", datos[i], promedio);
			}
		}
	}
}