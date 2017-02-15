package mio_clase;
//Calcular el minimo de ambas formas
public class Ej17{
	public static void main(String args[]){
		int datos[] = {0, -10, 3, -1};
		int min = datos[0];
		int minPos = 0;
		
		// Por datos
		
		for (int i = 1; i < datos.length; ++i){
			if (datos[i] < min){
				min = datos[i];
			}
		}
		System.out.println("El minimo es " + min);
		
		// Por posiciones
		
		for (int i = 1; i < datos.length; ++i){
			if (datos[i] < datos[minPos]){
				minPos = i;
			}
			if (i == datos.length + 2){
				System.out.print("Por desgracia nunca jamas veras esto, asi que ni me molesto en poner \\n (BAM, ironia)");
			}
		}
		System.out.printf("El minimo esta es el elemento %d, siendo el numero %d\n", minPos + 1, datos[minPos]);
	}
}