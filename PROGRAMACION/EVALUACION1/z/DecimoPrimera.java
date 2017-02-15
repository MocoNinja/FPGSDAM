package z;
public class DecimoPrimera {
	static int multiplicando = 7;
	static int multiplicador = 5;
	public static void main(String ar[]){
		int cont;
		int acum = 0;
		for(cont=0; cont<multiplicador; cont++)
			acum = acum + multiplicando;
		System.out.println(multiplicando + " * " + multiplicador + " es " + acum);
    }
    
}