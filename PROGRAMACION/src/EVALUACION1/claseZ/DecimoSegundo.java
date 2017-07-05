package EVALUACION1.claseZ;
public class DecimoSegundo {
	static int elementos = 7;
	static int tomados = 4;
	public static void main(String ar[]){
		int cont;
		int acum = elementos;
		for(cont=elementos-1; cont>tomados; cont--)
			acum *= cont;
		System.out.println("Variaciones de " + elementos + " elementos tomados de " + tomados + " en " + tomados + " es " + acum);
		System.out.printf("Variaciones de %d elementos tomados de %d en %d es %d \n", elementos, tomados, tomados, acum);
		System.out.println("Hola");
    }
}