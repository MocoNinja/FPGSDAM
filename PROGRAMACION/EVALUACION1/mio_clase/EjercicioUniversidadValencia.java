package mio_clase;
/*
* revisarlo que no funciona bien.
* Bien copiado creo que está 
*/
public class EjercicioUniversidadValencia {
/*
* Un reloj da a cada hora en punto tantas campanadas como la aguja.
* Algoritmitizarlo para horas pasadas como parámetro.
* Lo que queremos es el número de campanadas desde la hora hasta las 12 de la noche, ambas inclusive
*/
	public static void main(String[] args) {
		
		//System.out.println(relojNoRecursivo(22));
		System.out.println(relojRecursivo(10));

	}
	
	public static int relojNoRecursivo(int hora){
		
		if (hora >= 12)
			hora -= 12;
		int campanadas = hora;
	
		for (int i = hora + 1; i <= 12; i++)
			campanadas += i;
		if (hora <= 12){
			hora = 0;
		for (int i = hora + 1; i <= 12; i++)
			campanadas += i;
	}
//		int campanadas = 0;
//		for (int i = hora; i <= 24; i++){
//			if (hora > 12)
//				campanadas += (hora - 12);
//			else
//				campanadas += hora;
//		}
	return campanadas;
	}
	
	public static int relojRecursivo (int hora){

		if (hora == 24){
			return 12;
		} else {
			if (hora > 12){
				return (hora - 12) + relojNoRecursivo(hora + 1); 
			} else {
				return hora + relojRecursivo(hora + 1);
			}
			
		}
	}
	
	public static String multiplicaString(String string, int veces){
		
		String resultado = "";
		for (int i = 0; i < veces; i++)
			resultado += string;
	return resultado;
	}

}
