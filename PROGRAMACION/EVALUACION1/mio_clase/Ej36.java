package mio_clase;
/*
* Tenemos un cine con 4 salas
* En la tabla llamada salas se guardan el numero de entradas vendidas durante la semana.
* Es decir, tabla tiene 4 filas, de 7 elementos
* Aparte tenemos un vector llamado dias con dichos nombres
* Sacar los dias que mas y menos entradas se han vendido ( y cuantas)
* Dice que acumulemos sobre un vector las entradas vendidas cada dia
*/

/*
* EL PROBLEMA LO HE PLANTEADO BIEN A LA PRIMERA
* PERO HE PERDIDO MEDIA PUTA HORA
* PORQUE ENTRESEMANA NO TIENE 7 DIAS, SINO 5
* ANTES
* DE 
* PICAR
* CODIGO
* PIENSA
* BIEN
* EL 
* PUTO
* VECTOR
* !!!!!!
*
*	¬¬
*
* FIRMADO
* TU YO DEL PASADO...
*
*
* PD:
* ESTA REPRIMENDA OCUPA MAS QUE EL MALDITO CODIGO
* ASI QUE OJILLO!!!!
*/
public class Ej36{
	public static void main(String arg[]){
		int entradas [][]={{0, 1, 2, 3, 4}, {0, 1, 2, 3, 4}, {0, 1, 2, 3, 4}, {0, 1, 2, 3, 4}};
		String dias[] = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
		int vendidas[] = {0, 0, 0, 0, 0};
		/*
		int max = vendidas[0];
		String diaMax = dias[0];
		int min = vendidas[0];
		String diaMin = dias[0];
		*/
		int posMax = 0;
		int posMin = 0;
		for (int salas = 0; salas < entradas.length; ++salas){
			for (int dia = 0; dia < entradas[salas].length; ++dia){
				vendidas[dia] += entradas[salas][dia];				
				if (vendidas[dia] > vendidas[posMax]){
					posMax = dia;
					/*
					max = vendidas[dia];
					diaMax = dias[dia];
					*/
				}
				if (vendidas[dia] < vendidas[posMin]){
					posMin = dia;
					/*
					min = vendidas[dia];
					diaMin = dias[dia];
					*/
				}
			}
		}
		System.out.printf("Entradas max vendidas: %d, el %s.%n", vendidas[posMax], dias[posMax]);
		System.out.printf("Entradas min vendidas: %d, el %s.%n", vendidas[posMin], dias[posMin]);
	}
}
	
	
