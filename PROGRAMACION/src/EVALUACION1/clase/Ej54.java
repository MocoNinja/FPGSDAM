package EVALUACION1.clase;
/*
* Funcion recibe salarios
* Devuelve un vector de 3 enteros con la suma de su sueldo en los 5 meses
* MODIFICAR ESTO PARA QUE ACUMULE POR MES
*/
public class Ej54{
	public static void main(String argc[]){
		int sueldos [][] = {{1000, 1000, 1100, 1000, 1500},{1200, 1000, 1100, 1000, 1200},{1500, 1500, 1600, 1600, 2000}};
		String empleado[] = {"Wenceslao Pérez Montoya", "Ambrosio Gómez Fernández", "María Dolores Fuertes Debarriga"};
		String mes[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo"};
		cantaor(sueldoNetoEmpleado(sueldos), empleado);
		cantaor(sueldoNetoMes(sueldos), mes);
	}
	
	public static int[] sueldoNetoEmpleado(int vector[][]){ /*Énfasis: tipo = int[]*/ /*Definicion alternativa: int [][] vector*/
		int suma = 0;
		int resultado[] = new int[vector.length]; /*RECORDAR ESTA SINTAXIS!!!!*/
		for (int i = 0; i < vector.length; ++i){
			suma = 0;
			for (int j = 0; j < vector[i].length; ++j){
				suma += vector[i][j];
			}
			resultado[i] = suma;
		}
	return resultado;
	}
	
	public static int[] sueldoNetoMes(int vector[][]){
		int suma = 0;
		int resultado[] = new int[vector[0].length];
		for (int i = 0; i < resultado.length; ++i){
			suma = 0;
			for (int j = 0; j < vector.length; ++j){
				suma += vector[j][i];
			}
			resultado[i] = suma;
		}
	return resultado;
	}

	public static void cantaor(int vector1[], String vector2[]){
		for (int i = 0; i < vector1.length; ++i){
			System.out.printf("%nEl sueldo acumulado de %s es %d...%n", vector2[i],vector1[i]);
		}
	}
	
}