package EVALUACION1.claseZ;
public class Trigesimo {

	public static void main(String arcccccc[]){
		int tabla[][] = {{10, 20, 30, 40, 15}, {50, 60, 70, 80, 75}, {90, 100, 110, 120, 30}};
		String productos[] = {"Naranjas", "Peras", "Melones"};
		int acum;
		for(int i=0; i<tabla.length; i++){
			acum = 0;
			for(int j=0; j<tabla[i].length; j++)
				acum += tabla[i][j];
			System.out.printf("He vendido %d kilos de %s\n", acum, productos[i]);
		}
    }
    
    
}