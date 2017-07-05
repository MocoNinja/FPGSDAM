package EVALUACION1.clase;
/*
* Ejercicio:
* Numeros impares: cambiar signo
* Numeros pares: sumarles 1
*/
public class Ej21{
	public static void main(String arg[]){
		int datos[] = {0, 2, -2, -3, 3};
		for (int i = 0; i < datos.length; ++i){
			if (datos[i] == 0){
				datos[i] = 0;
			} else if (datos[i] % 2 == 0 || datos[i] % 2 == 0){
					datos[i] += 1;
				
			} else {
				datos[i] = - datos[i];
			}
		}
		System.out.printf("El vector nuevo es: { ");
		for (int i = 0; i < datos.length; ++i){
			System.out.printf("%d ", datos[i]);
		}
		System.out.printf("}\n");
	}
}