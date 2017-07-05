package EVALUACION1.clase;
public class Ej19{
	public static void main(String arg[]){
		int datos[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		int longitud = datos.length; /*Esto puede omitirse perfectamente*/
		int limite = longitud / 2; /*Esto puede omitirse aún más perfectamente*/
		
	//	System.out.printf("La longitud del vector es %d\n", longitud);
	//	System.out.printf("El limite del bucle va a ser %d\n", limite);
	
/*		
		int datosInvertidos[longitud];
		for (int i = 0; i <= longitud; ++i){
			datosInvertidos[i] = datos[longitud - 1 - i];
		}
*/  

/*
* El lo ha planteado con variables intermedias.
* Es mucho mejor porque con una variable te ahorras n. 
* Ademas el bucle es el doble de largo.
*/

	int aux = 0;
	System.out.printf("El vector original es: { ");
	for (int i = 0; i < longitud; ++i){
		System.out.printf("%d ", datos[i]);
	}
	System.out.printf("}\n");
	for (int i = 0; i < longitud / 2; ++i){
		//System.out.printf("El elmento original de la posicion %d es %d\n", i, datos[i]);
		aux = datos[i];
		//System.out.printf("La variable auxiliar vale %d\n", aux);
		datos[i] = datos[longitud - 1 - i];
		datos[longitud - 1 - i] = aux;
		//System.out.printf("El elmento nuevo de la posicion %d es %d\n", i, datos[i]);
	}
	System.out.printf("El vector nuevo es: { ");
	for (int i = 0; i < longitud; ++i){
		System.out.printf("%d ", datos[i]);
	}
	System.out.printf("}\n");
	}
}