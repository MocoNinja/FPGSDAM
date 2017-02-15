package mio_clase;
/*
* Lo de antes, pero con precios
*/

public class Ej35{
	public static void main(String argc[]){
		String productos[] = {"Naranjas", "Peras", "Melones"};
		double precios[] = {0.75, 0.85, 0.90};
		double ventas[][] = {{10.4, 20.0, 10.0, 12.7, 16.2}, {22.0, 23.1, 15.1, 11.8, 18.4}, {13.5, 12.0, 38.7, 22.8, 13.9}};
		double ganancias;
		for (int producto = 0; producto < productos.length; ++producto){
			ganancias = 0;
			for (int dia = 0; dia < ventas[producto].length; ++dia) {
				ganancias += ventas[producto][dia] * precios[producto];
			}
			System.out.printf("La venta de %8s ha generado ingresos de %5.2f euros...\n", productos[producto], ganancias);
		}
	}
}