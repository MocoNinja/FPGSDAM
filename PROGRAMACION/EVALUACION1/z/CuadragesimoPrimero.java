package z;
public class CuadragesimoPrimero {

	public static void main(String arg[]){
		int edades[][] = {{18, 19, 22, 20, 33}, {22, 24, 19, 21, 25}, {16, 17, 16, 18, 16}, {18, 19, 17, 17, 17}};
		String clases[] = {"1H", "2H", "1E", "2E"};
		double acum;
		
		for(int i=0; i<edades.length; i++){
			acum = 0;
			for(int j=0; j<edades[i].length; j++)
				acum += edades[i][j];
			System.out.printf("La edad media de %s es %.2f\n", clases[i], (acum/edades[i].length));
		}		
				
    }
    
    
}