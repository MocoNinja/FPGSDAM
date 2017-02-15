package EXAMEN;


public class Ejercicio2 {

	public static void main(String[] args) {
		
		//String[] movimientos = {"nacimientos", "defunciones", "traslados", "asentamientos"};
		String[] meses = {"enero", "febrero", "marzo","abril", "mayo","junio","julio", "agosto", "septiembre","octubre", "noviembre", "diciembre"};
		
		//aumenta poblacion
		int[][] nacimientos = {{0,3,2},{3,4,5},{6,4,8},{9,0,1}};
		int[][] asentamientos = {{1,4,2},{3,4,5},{6,0,8},{0,0,1}};
		//diminuye poblacion
		int[][] defunciones = {{2,5,2},{15,4,5},{6,7,9},{9,9,2}};
		int[][] traslados = {{0,0,3},{3,4,5},{6,3,8},{1,0,2}};
		
		
		
		int trimestreConMasNacimientos = detectaTrimestreMasNacimientos(nacimientos) + 1;
		System.out.println("El trimestre número " + trimestreConMasNacimientos + " es el que más nacimientos ha registrado");
		String mesMortal = detectaMasBajas(defunciones, traslados, meses);
		System.out.println("El mes con más pérdidas de población ha sido " + mesMortal);
		
		int variacion = variacionPoblacion(defunciones, traslados, nacimientos, asentamientos);
		//System.out.println(variacion);
		if (variacion == 0){
			System.out.println("La población no ha variado en términos absolutos");
		} else if (variacion > 0){
				System.out.println("La población total ha aumentado");
			} else {
				System.out.println("La población total ha disminuido");
		}
		
	}
	
	public static int detectaTrimestreMasNacimientos(int[][] nacimientos){
		int max = 0;
		int indice = 0;
		int[] nacimientosTrimestre = {0,0,0,0};
		for (int i = 0; i < nacimientos.length; i++, indice++){
			for (int j = 0; j < nacimientos[i].length; j++){
				nacimientosTrimestre[indice] += nacimientos[i][j];
			}
		}
		//leeVector(nacimientosTrimestre);		
		max = detectaMax(nacimientosTrimestre);
		//System.out.println("El máximo está en " + max);
	return max;
	}
	
	public static String detectaMasBajas(int[][] defunciones, int[][] traslados, String[] meses){
		
		int[] bajasMes = {0,0,0,0,0,0,0,0,0,0,0,0};
		int mesMax = 0;
		int indice = 0;
		String mesMortal = "";
		
		// carga las bajas totales
		for (int i = 0; i < defunciones.length; i++, indice++){ 
			for (int j = 0; j < defunciones[i].length; j++){
				bajasMes[indice] += defunciones[i][j];
				bajasMes[indice] += traslados[i][j];
				
			}
		}
		mesMax = detectaMax(bajasMes);
		mesMortal = meses[mesMax];
	return mesMortal;
	}
	
	
	
	
	public static int detectaMax (int[] vector){
		int max = 0;
		for (int i = 0; i < vector.length; i++){
			if (vector[i] > vector[max]){
				max = i;
			}
		}
	return max;
	}
	
	public static void leeVector(int[] vector){
		for (int i = 0; i < vector.length; i++){
			System.out.println(vector[i]);
		}
	}

	public static int variacionPoblacion(int[][] defunciones, int[][] traslados, int[][] nacimientos, int[][] asentamientos){
		int variacionPoblacion = 0;
		for (int i = 0; i < nacimientos.length; i++){
			for (int j = 0; j < nacimientos[i].length; j++){
				variacionPoblacion = variacionPoblacion + nacimientos[i][j] + asentamientos[i][j] - defunciones[i][j] - traslados[i][j];
			}
		}
	return variacionPoblacion;
	}
}
