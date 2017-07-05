package EVALUACION1.clase;
/*
* Ejercicio: 
* Todos los elementos del vector se desplace una posicion hacia la izquierda
* El primero debe pasar al final
*/

public class Ej24{
	public static void main(String arg[]){
		/*
		* Lógica de clase
		* Si recorremos de izquierda a derecha, el unico valor que se destruiria seria el primero
		* Que es el que hay que colocar al final por lo que es bastante fijo
		* A mi se me estaba ocurriendo algo parecido pero al reves
		*/
		int datos[] = {0, 1, 2, 3, 4};
		
		System.out.printf("El vector viejo es: { ");
			for (int i = 0; i < datos.length; ++i){
				System.out.printf("%d ", datos[i]);
			}
		System.out.printf("}\n");
		
		/*
		* Mirando mi propuesta es mucho mas ineficiente porque tendria que declarar bastante variables
		* teniendo que hacer muchos intercambios
		* y teniendo que meter bastante excepciones
		* Así que quedarse con esta lógica más sencilla.
		* Lo que si puede hacerse es el mismo codigo como lo habia planteado yo,
		* pero al reves para a derecha
		*
		* 								ES DECIR
		*
		* PARA USAR UNA SOLA VARIABLE HAY QUE RECORRER EL BUCLE EN LA DIRECCIÓN 
		* 		CONTRARIA A LA QUE QUEREMOS DESPLAZAR LOS VALORES
		*
		* De esta forma no hay sobreescrituras, pues el valor que sobreescribimos esta duplicado
		*	^	^	^	^	^	^	^	^	^	^	^	^	^	^	^	^	^	^	^	^	^
		*	|	|	|	|	|	|	|	|	|	|	|	|	|	|	|	|	|	|	|	|	|
		*
		*							THE COOL WAY TO THINK
		*
		*/	
///* 
		final int aux = datos[datos.length - 1];
		for (int i = datos.length - 1; i > 0; --i){
			datos[i] = datos [i - 1];
		}
		datos[0] = aux;
//*/
/*	
		final int aux = datos[0];
		for (int i = 0; i < datos.length - 1; ++i){
			datos[i] = datos[i + 1];
		}
		datos[datos.length - 1] = aux;
*/
		System.out.printf("El vector nuevo es: { ");
			for (int i = 0; i < datos.length; ++i){
				System.out.printf("%d ", datos[i]);
			}
		System.out.printf("}\n");	
	}
}
