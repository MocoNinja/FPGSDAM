package EVALUACION1.rehechoRepaso;

public class VectorEnterosMaxyMin {

	public static void main(String[] args) {
		
		int[] vector = {0, -3, 4, 9, -8, -2, 7, -1};
		detectaMaxAbs(vector);
		detectaMinAbs(vector);
		detectaMaxPos(vector);
		detectaMinPos(vector);
	}
	
	public static void detectaMaxAbs(int[] vector){
		int max = 0;
		for (int i = 0; i < vector.length; i++){
			if (vector[i] > max){
				max = vector[i];
			}
		}
		System.out.println("El elemento máximo del vector es: " + max);
	}
	
	public static void detectaMinAbs(int[] vector){
		int min = 0;
		for (int i = 0; i < vector.length; i++){
			if (vector[i] < min){
				min = vector[i];
			}
		}
		System.out.println("El elemento mínimo del vector es: " + min);
	}

	public static void detectaMaxPos(int[] vector){
		int maxpos = 0;
		for (int i = 0; i < vector.length; i++){
			if (vector[i] > vector[maxpos]){
				maxpos = i;
			}
		}
		System.out.println("El elemento máximo del vector es: " + vector[maxpos] + ", estando en " + maxpos);
	}
	
	public static void detectaMinPos(int[] vector){
		int minpos = 0;
		for (int i = 0; i < vector.length; i++){
			if (vector[i] < vector[minpos]){
				minpos = i;
			}
		}
		System.out.println("El elemento máximo del vector es: " + vector[minpos] + ", estando en " + minpos);
	}
	
}
