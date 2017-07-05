package EVALUACION1.rehechoRepaso;

public class VectorLeer {

	public static void main(String[] args) {
		
		int[] vector1 = {0, 1, 2, 3};
		double[] vector2 = {0.0, 1.0, 2.0, 3.0};
		String[] vector3 = {"Pepe", "Juan"};
		leerVectorEntero(vector1);
		leerVectorDouble(vector2);
		leerVectorString(vector3);
	}
	
	public static void leerVectorEntero(int[] vector){
		System.out.print("{ ");
		for (int i = 0; i < vector.length; i++){
			System.out.print(vector[i]);
			System.out.print(" ");
		}
		System.out.print("}\n");
	}
	
	public static void leerVectorString(String[] vector){
		System.out.print("{ ");
		for (int i = 0; i < vector.length; i++){
			System.out.print(vector[i]);
			System.out.print(" ");
		}
		System.out.print("}\n");
	}
	
	public static void leerVectorDouble(double[] vector){
		System.out.print("{ ");
		for (int i = 0; i < vector.length; i++){
			System.out.print(vector[i]);
			System.out.print(" ");
		}
		System.out.print("}\n");
	}

}
