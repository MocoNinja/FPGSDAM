package mio_clase;
/*
* Combinar lo anterior en: lo mejor y peor de la semana (es decir, sacar el maximo y minimo, diciendo dia y peli);
*/

public class Ej38{
	public static void main(String arg[]){
		int entradas [][]={{10, 10, 10, 10, 110}, {10, 1, 10, 10, 10}, {2, 2, 2232, 2, 2}, {3, 3, 3, 3, 3}};
		String diasNombre[] = {"Lunes", "Martes", "Mi?coles", "Jueves", "Viernes"};
		String peliculas[] = {"El Resplandor", "Chinese SuperNinjas", "Evil Dead", "Escape de NY"};
		//int xacum[] = {0, 0, 0, 0, 0}; //no hace falta
		//int yacum[] = {0, 0, 0, 0}; //no hace falta
		int xmax = 0, xmin = 0, ymax = 0, ymin = 0;
		for (int filas = 0; filas < entradas.length; ++filas){
			for (int columnas = 0; columnas < entradas[filas].length; ++columnas){
				/*
				* No hace falta acumular. Se puede sacar el indice directo.
				*/
				
///*
				if (entradas[filas][columnas] > entradas[ymax][xmax]){
					xmax = columnas;
					ymax = filas;
				}
					/*
					* Seguramente sea m? eficaz meter alguna comparacion en el otro bucle
					* pero por comodidas y variar estas formas (mia y corregida)
					* lo dejo apelotonao
					*/
					if (entradas[filas][columnas] < entradas[ymin][xmin]){
					xmin = columnas;
					ymin = filas;
				}
//*/
/*
				xacum[columnas] += entradas[filas][columnas];
				yacum[filas] += entradas[filas][columnas];
				if (xacum[columnas] > xacum[xmax]){
					xmax = columnas;
				} else if (xacum[columnas] < xacum[xmin]){
					xmin = columnas;
				}
				if (yacum[filas] > yacum[ymax]){
					ymax = filas;
				} else if (yacum[filas] < yacum[ymin]){
					ymin = filas;
*/
			}
		}
/*
		System.out.printf("El max numero de entradas, %d, se alcanzo el %s.%n La peli mas vista fue %s%n", xacum[xmax], diasNombre[xmax], peliculas[ymax]);
		System.out.printf("El min numero de entradas, %d, se alcanzo el %s.%n La peli mas vista fue %s%n", xacum[xmin], diasNombre[xmin], peliculas[ymin]);
*/
///*
			System.out.printf("La maxima audiencia se alcanzo el %s, en la sesion del %s.%n",diasNombre[xmax], peliculas[ymax]);
			System.out.printf("La maxima audiencia se alcanzo el %s, en la sesion del %s.%n",diasNombre[xmin], peliculas[ymin]);
//*/
	}
}