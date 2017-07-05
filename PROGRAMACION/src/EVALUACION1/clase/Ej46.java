package EVALUACION1.clase;
/*
* Tabla de goles 4x5
* 5 jugadores
* 4 ultimos años
* sacar la media de jugador por año
*/

public class Ej46{
	public static void main(String argc[]){
		int goles[][]={{1,19,18,20,250},{1,19,19,20,250},{1,29,19,20,250},{1,19,40,20,250}};
		String jugadores[] = {"Jugador1","Jugador2","Jugador3","Jugador4", "Jugador5"};
		int golesAcumulados;
		for (int jugador = 0; jugador < jugadores.length; ++jugador){
			golesAcumulados = 0;
			for (int ano/*jajaja xd*/ = 0; ano < goles.length; ++ano){
				golesAcumulados += goles[ano][jugador];
			}
			System.out.printf("Los goles medios por año de %s son %d%n", jugadores[jugador], golesAcumulados/goles.length);
		}
	}
}