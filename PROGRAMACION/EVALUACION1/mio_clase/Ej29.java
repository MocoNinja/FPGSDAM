package mio_clase;
/*
* ARRAYS 2D: TABLAS
*/
public class Ej29{
	public static void main(String arg[]){
		/*Declaración de una tabla: es un vector con 'filas' vectores de 'columnas' elementos*/
						/*OSEASE: ES un VECTOR DE VECTORES*/
						
		int tabla[][] = {{10,20,30,40}, {50,60,70,80}, {90,100,110,120}};
		//System.out.println(tabla.length);
		for (int i = 0; i < tabla.length; ++i){
			for(int j = 0; j < tabla[i].length; ++j){
				System.out.printf(" %3d ", tabla[i][j]);
			}
			System.out.println();
		}
	}
}