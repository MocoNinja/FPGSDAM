package EVALUACION1.claseZ;
public class TrigesimoOctavo {

	public static void main(String arcccccc[]){
		int tabla1[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		int tabla2[][] = new int[4][4];
	
		for(int i=0; i<tabla1.length; i++)
			for(int j=0; j<tabla1[i].length; j++)
				tabla2[j][i] = tabla1[i][j];
		
		for(int i=0; i<tabla1.length; i++){
			for(int j=0; j<tabla1[i].length; j++)
				System.out.printf("%d   ", tabla2[i][j]);
			System.out.println();
		}
	}
    
}