package EVALUACION1.clase;
/*
* Empezamos con las funciones
* Encabezado de la funcion: modificadores tiporetorno nombre (tipo argumento){}
* Por ahora: modificadores public static
*/

public class Ej51{
	
	public static void main(String arg[]){
/*
		ascribe();
		ascribeAlgo("Como mola tron!!!!");
		String algo = "'redundancia' A.K.A: varibles a nivel local";
		System.out.println(algo);
		animal_habla("Santa claus", "dame alcohol");
*/
		System.out.println(concatenar("git", "gud"));
		System.out.println(suma(1,2));
		
	}
	
	public static void ascribe(){
		System.out.println("hola");
	}
	
	public static void ascribeAlgo(String algo){
		System.out.println(algo);
	}
	
	public static void animal_habla(String animal, String onomatopeya){
		System.out.println(animal + " dice " + "'" + onomatopeya + "'" + "." );
	}
	
	public static String concatenar(String uno, String dos){
		return uno + dos; //como en C
	}
	
	public static int suma(int a, int b){
		/*if (1 > 2)*/ //Error de compilacion: siempre debe retornar
			return a + b;
	}
}