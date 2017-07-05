package EVALUACION1.clase;
/*
* Ejercicio propuesto
* Vector con valores enteros (positivos y negativos)
* Modificar el vector de manera que los negativos sean positivos, y los positivos se multipliquen por 2
*/

public class Ej20{
	public static void main(String arg[]){
		int datos[] = {0, -10, 4, -30};
		int longitud = datos.length;
		System.out.printf("El vector original es: { ");
		for (int i = 0; i < longitud; ++i){
			System.out.printf("%d ", datos[i]);
		}
		System.out.printf("}\n");
		for (int i = 0; i < datos.length; ++i){
			if (datos[i] < 0){
				datos[i] = - datos[i];
			} else {
				datos[i] *= 2;
			}
		}
		System.out.printf("El vector nuevo es: { ");
		for (int i = 0; i < longitud; ++i){
			System.out.printf("%d ", datos[i]);
		}
		System.out.printf("}\n");
	}
}