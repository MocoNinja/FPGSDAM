package mio_clase;
/*
* Partimos de un vector de enteros
* Lo ordenamos mediante un metodo que reciba un vector y lo devuelva ordenado
* El algoritmo de orden no importa
*/
class Ej55{
	
	public static void main(String ad[]){
		int lista[] = {0, -1, 5, -4, 4, 19, 12};
		//leer(ordenaVector(lista)); //al cambiar el metodo a void, agruparlos da error.
		ordenaVector(lista);
		leer(lista);
	}
	
	public static /*int[]*/ void ordenaVector(int vector[]){
		for (int i = vector.length - 1; i > 0; --i){
			int j = i;
			int aux = 0;
			while((j > 0) && (vector[j] < vector[j - 1])){
				aux = vector[j];
				vector[j] = vector [j - 1];
				vector[j - 1] = aux;
				--j;
			}
		}
	/*return vector;*/
	}
	
	/*
	* La lógica de que este tipo de funciones sean void es que si quieres usar el metodo de pintar columna,
	* para qué demonios quieres devolverla. La pintas y plás.
	*/
	
	public static void leer(int vector[]){
		System.out.printf("El vector es:%n{");
		for (int i = 0; i < vector.length; ++i){
				System.out.printf(" %d ", vector[i]);
			}
		System.out.printf("}%n");
	}
	
}