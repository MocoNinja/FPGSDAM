package mio_clase;
/*
* Sacar la matriz traspuesta
* Partimos de una matriz cuadrada
* Entos los elementos de cada fila (a00, a00...) pasaran a ser una columna (a00, a10)
* La matriz transpuesta debe estar vacia y cargarse la traspuesta directamente
*/
public class Ej42{
	public static void main(String arg[]){
		int matriz[][] = {{0,1,2}, {3,4,5}, {6,7,8}};
		int traspuesta[][] = {{0,0,0}, {0,0,0}, {0,0,0}};
		for (int fila = 0; fila < matriz.length; ++fila){
			for (int columna = 0; columna < matriz[fila].length; ++columna){
				traspuesta[columna][fila] = matriz[fila][columna];
			}
		}
	}
}