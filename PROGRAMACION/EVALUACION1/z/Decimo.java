package z;
public class Decimo {
	static int numero = 7;
	public static void main(String ar[]){
		int cont;
		int acum=1;
		for(cont = 1; cont<=numero; cont++)
			acum = acum * cont;
		System.out.println("Factorial de " + numero + " es " + acum);
		
		acum = numero;
		for(cont=(numero-1); cont>=1; cont--)
			acum = acum * cont;
		System.out.println("Factorial de " + numero + " es " + acum);
    }
       
}