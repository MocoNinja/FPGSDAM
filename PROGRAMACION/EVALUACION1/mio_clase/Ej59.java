package mio_clase;

/*
* Calcular los sueldos totales mediante funciones
*/


public class Ej59 {

	public static void main(String[] args) {
		int [][] salarios = {{1,2,3,4,5},{1,3,5,7,9},{9,1,3,4,5},{9,1,3,4,5},{9,1,3,4,5}};
		String[] empleados = {"Papa","Pepe","Pipi","Popo","Pupu"};
		for (int i = 0; i < empleados.length; ++i)
			System.out.printf("El sueldo acumulado de %s es %d.%n", empleados[i], sueldoNeto(salarios, i));
	}
	
	public static int sueldoNeto(int[][] vector, int empleado){
		int acumulado = 0;
			for (int iterator = 0; iterator < vector[empleado].length; ++iterator){
				acumulado += vector[empleado][iterator];
			}
	return acumulado;
		}

}
