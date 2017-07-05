package EVALUACION1.clase;
/*
* Ordenar los elementos de este vector de Strings por orden alfabético
* http://stackoverflow.com/questions/5153496/how-can-i-compare-two-strings-in-java-and-define-which-of-them-is-smaller-than-t
*/
public class Nuevo5 {
	public static void main(String[] argc) {
   		String[] nombres = {"Pepe", "Juan", "María", "Antonio", "Luisa"};
   						   /* 4,      1,     3,          0,     2        */
  	   	String[] nombresOrdenados = new String[nombres.length];
  	   	/*
  	   	* MIRAR LOS METODOS VIEJOS PARA HACERLO SOBRE LA CADENA ORIGINAL!!!!!
  	   	*/
  	   	String Primero = nombres[0];
  	   	System.out.println(Primero);
  	   	int j = 0;
  	   	for (int i = 1; i < nombres.length; i++){
  	   		System.out.println("Mirando " + nombres[i]);
  	   			if (nombres[i].compareTo(nombres[i - 1]) < 0){
  	   				System.out.println(nombres[i] + ">" + nombres[i-1]);
  	   			Primero = nombres[i];
  	   			nombresOrdenados[j] = Primero;
  	   			j++;
  	   			}
  	   	}
  	   	for (int i = 0; i < nombresOrdenados.length; i++)
  	   		System.out.println(nombresOrdenados[i]);
    }
}