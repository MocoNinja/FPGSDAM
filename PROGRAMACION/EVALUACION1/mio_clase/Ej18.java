package mio_clase;
//Calcular ambos de ambas formas
public class Ej18{
	
	public static void main(String args[]){
		
		int datos[] = {576540, -10, 3, -100};
		int min, max;
		min = max = datos[0];  //alternativa: int maximo = 0, minimo = 0;
		int maxPos, minPos;
		maxPos = minPos = 0;
		
		// Por datos
		
		for (int i = 1; i < datos.length; ++i){
			if (datos[i] < min){
				min = datos[i];
			} else if (datos[i] > max){
				max = datos[i];
			}
		}
		System.out.printf("El maximo es %d y el minimo es %d\n", max, min);
		
		// Por posiciones
		
		for (int i = 1; i < datos.length; ++i){
			if (datos[i] < datos[minPos]){
				minPos = i;
			} else if (datos[i] > datos[maxPos]){
				maxPos =i;
			}	
		}
		System.out.printf("El maximo esta en la posicion %d y vale %d; el minimo esta en la posicion %d y vale %d\n", maxPos + 1, datos[maxPos], minPos + 1, datos[minPos]);
	}
}