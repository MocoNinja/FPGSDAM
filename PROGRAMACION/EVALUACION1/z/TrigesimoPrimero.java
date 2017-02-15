package z;
public class TrigesimoPrimero {

	public static void main(String arcccccc[]){
		int tabla[][] = {{10, 20, 30, 40, 15}, {50, 60, 70, 80, 75}, {90, 100, 110, 120, 30}};
		String productos[] = {"Naranjas", "Peras", "Melones"};
		double precios[] = {1.5, 2, 0.8};
		double acum;
		double total = 0;
		for(int i=0; i<tabla.length; i++){
			acum = 0;
			for(int j=0; j<tabla[i].length; j++)
				acum += tabla[i][j] * precios[i];
			System.out.printf("He vendido %.2f euros de %s\n", acum, productos[i]);
			total += acum;
		}
		System.out.printf("El total vendido es %.2f", total);
    }
    
    
}