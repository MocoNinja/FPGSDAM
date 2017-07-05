package EVALUACION1.claseZ;
public class CuadragesimoSegundo {

	public static void main(String arg[]){
		int goles[][] = {{18, 19, 22, 20, 33}, {22, 24, 19, 21, 25}, {16, 17, 16, 18, 16}, {18, 19, 17, 17, 17}};
		String futbolistas[] = {"Messi", "Ronaldo", "Grizzman", "Suárez", "Neimar"};
		double acum;
		
		for(int j=0; j<futbolistas.length; j++){
			acum = 0;
			for(int i=0; i<goles.length; i++)
				acum += goles[i][j];
			System.out.printf("La media de goles de %s es %.1f por partido\n", futbolistas[j], (acum / goles.length));
		}
				
    }
    
    
}