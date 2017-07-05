package EVALUACION1.claseZ;
public class TrigesimoNoveno {

	public static void main(String arcccccc[]){
		int tabla1[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		int inter;
		for(int i=0; i<tabla1.length; i++)
			for(int j=i; j<tabla1[i].length; j++){
				inter = tabla1[j][i];
				tabla1[j][i] = tabla1[i][j];
				tabla1[i][j] = inter;
			}
			
		for(int i=0; i<tabla1.length; i++){
			for(int j=0; j<tabla1[i].length; j++)
				System.out.printf("%d   ", tabla1[i][j]);
			System.out.println();
		}
		
    }
    
    
}