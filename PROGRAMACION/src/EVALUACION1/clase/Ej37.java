package EVALUACION1.clase;
/*
* Ahora tenemos un vector que se llama Peliculas, una por cada sala
* Añadir la pelicula mas vista y la menos vista
*/

public class Ej37{
public static void main(String arg[]){
		int entradas [][]={{0, 1, 2, 3, 4}, {0, 1, 2, 3, 4}, {0, 1, 2, 3, 4}, {0, 1, 2, 3, 4}};
		String dias[] = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
		int vendidas[] = {0, 0, 0, 0, 0};
		int posMax = 0;
		int posMin = 0;
		for (int salas = 0; salas < entradas.length; ++salas){
			for (int dia = 0; dia < entradas[salas].length; ++dia){
				vendidas[dia] += entradas[salas][dia];				
				if (vendidas[dia] > vendidas[posMax]){
					posMax = dia;
				}
				if (vendidas[dia] < vendidas[posMin]){
					posMin = dia;
				}
			}
		}
		System.out.printf("Entradas max vendidas: %d, el %s.%n", vendidas[posMax], dias[posMax]);
		System.out.printf("Entradas min vendidas: %d, el %s.%n", vendidas[posMin], dias[posMin]);
	}
}