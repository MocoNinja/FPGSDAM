package EVALUACION1.clase;
public class Ej14{
	public static void main(String args[]){
		/*						
		*									Vectores
		* Estructura que contiene variables del mismo tipo en localizaciones de memorias contiguas.
		*
		*/
		int datos[] = {17, 55, 33, 21, 44};
/*
		int longitud = datos.length;													
		System.out.println("datos.length = " + longitud);         
		
*/      	
		for (int i = 0; i <= 4; ++i){
		//	System.out.printf("Cambiando el elemento datos[%d], de %d a %d\n",i, datos[i], 2*datos[i]);
			datos[i] *= 2; /*Esta línea devuelve el vector doble*/
			System.out.printf("Datos[%d] = %d\n", i, datos[i]);
		}
/*		
		for (int i = 0; i < datos.length; ++i){
			System.out.printf("Datos[%d] = %d\n", i, datos[i]);
		}
*/
	}
}