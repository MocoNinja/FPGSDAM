package EVALUACION1.clase;
/*
* Ejercicio:
* Calcular la media de los elementos del vector
*/
public class Ej22{
	public static void main(String arg[]){
		double datos[] = {0, 3, 1, 65};
		double suma = 0;
		for (int i = 0; i < datos.length; ++i){
			suma += datos[i];
		}
		double promedio = suma / datos.length;
		System.out.printf("La media es %.2f\n", promedio);
	}
}