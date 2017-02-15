package mio_clase;
//Calcular el maximo con una variable que guarde la posicion, no el valor
public class Ej16{
	public static void main(String args[]){
		int datos[] = {0, 10, 3, -1};
		int maxPos = 0;
		for (int i = 1; i < datos.length; ++i){
			if (datos[i] > datos[maxPos]){
				maxPos = i;
			}
		}
		System.out.printf("El maximo esta es el elmento %d, siendo el numero %d\n", maxPos + 1, datos[maxPos]);
	}
}