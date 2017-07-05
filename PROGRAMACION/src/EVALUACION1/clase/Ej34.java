package EVALUACION1.clase;
/*
* Vamos a hacer un vector de Strings, productos
* Hacemos una tabla de 3 x 5, ventas (3 productos, 5 dias)
* Sacar una lista de cuanto hemos vendido de cada cosa
*/

public class Ej34{
	public static void main(String arg[]){
		String productos[] = {"Naranjas", "Peras", "Melones"};
		int ventas[][] = {{0,0,0,0,1}, {2, 0, 0, 0 ,0}, {1000, 1000, 1000, 1000, 1000}};
		//System.out.println(ventas.length);
		//System.out.println(ventas[0].length);
		//int ventasTotales = 0; //Se puede hacer de varias maneras. El lo declara aqui y lo inicializa al principio del bucle principal
		for (int producto = 0; producto < productos.length; ++producto){
			int ventasTotales = 0;
			for (int dia = 0; dia < ventas[producto].length; ++dia){
				ventasTotales += ventas[producto][dia];
			}
			System.out.printf("Las ventas de %s esta semana han sido %4d kilos...\n", productos[producto], ventasTotales);
			//ventasTotales = 0; //Ojo con olvidarse de esto si no se reasigna/declara la variable en el bucle principal
		}
		
	}
	
}