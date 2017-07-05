package EVALUACION1.rehechoRepaso;

public class TablaLeer {

	public static void main(String[] args) {
		
		int[][] tabla1 = {{0, 1, 2, 3}, {0, 1, 2, 3}, {0, 1, 2, 3}};
		double[][] tabla2 = {{0.0, 1.0, 2.0, 3.0}, {0.0, 1.0, 2.0, 3.0}, {0.0, 1.0, 2.0, 3.0}};
		String[][] tabla3 = {{"Pepe", "Juan"}, {"Pepe", "Juan"}, {"Pepe", "Juan"}};
		leerVectorEntero(tabla1);
		leerVectorDouble(tabla2);
		leerVectorString(tabla3);
	}
	
	public static void leerVectorEntero(int[][] tabla){
		for (int j = 0; j < tabla.length; j++){
			System.out.print("{ ");
			for (int i = 0; i < tabla[j].length; i++){
				System.out.print(tabla[j][i]);
				System.out.print(" ");
			}
			System.out.print("}\n");
		}
	}
	
	public static void leerVectorString(String[][] tabla){
		for (int j = 0; j < tabla.length; j++){
			System.out.print("{ ");
			for (int i = 0; i < tabla[j].length; i++){
				System.out.print(tabla[j][i]);
				System.out.print(" ");
			}
			System.out.print("}\n");
		}
	}
	
	public static void leerVectorDouble(double[][] tabla){
		for (int j = 0; j < tabla.length; j++){
			System.out.print("{ ");
			for (int i = 0; i < tabla[j].length; i++){
				System.out.print(tabla[j][i]);
				System.out.print(" ");
			}
			System.out.print("}\n");
		}
	}

}
