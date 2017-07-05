package EVALUACION1.clase;
//Calcular el maximo
public class Ej15{
	public static void main(String args[]){
		int datos[] = {-10, -1000, -56, -78, -44, 10000};
		int max = datos[0];
		for (int i = 1; i < datos.length; ++i){
			/*System.out.println("Por ahora, el maximo es " + max);*/
			/*Ya ha explicado datos.length*/
			if (datos[i] > max){
				max = datos[i];
			}
		}
		System.out.println("El elemento maximo del vector es " + max);
	}
}