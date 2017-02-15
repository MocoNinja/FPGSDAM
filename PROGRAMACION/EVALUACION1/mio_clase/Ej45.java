package mio_clase;
/*
* Array 4x5 edades
* y's: clases (1h,2h,1e,2e)
* x's: edades de los 5 alumnos de cada clase
* Mostrar la media de edad de cada clasep
*/

public class Ej45 {
	public static void main(String arg[]){
		int edades[][]={{18,19,18,20,25},{19,19,19,20,35},{19,29,19,20,18},{19,19,40,20,35}};
		String clases[] = {"1h","2h","1e","2e"};
		int edadAcumulada;
		for (int filas = 0; filas < edades.length; ++filas){
			edadAcumulada = 0;
			for (int columnas = 0; columnas < edades[filas].length; ++columnas){
				edadAcumulada += edades[filas][columnas];
			}
			System.out.printf("La edad media de la clase %s es %d%n", clases[filas], edadAcumulada/edades[filas].length);
		}
	}
}