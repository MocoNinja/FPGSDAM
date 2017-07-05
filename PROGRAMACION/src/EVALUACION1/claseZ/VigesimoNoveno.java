package EVALUACION1.claseZ;
public class VigesimoNoveno {

	public static void main(String arcccccc[]){
		int tabla[][] = {{10, 20, -30, -40}, {50, 60, -70, 80}, {90, 100, -110, 120}};
		int v1[] = {0, 0, 0};
		int v2[] = {0, 0, 0, 0};
		for(int i=0; i<tabla.length; i++)
			for(int j=0; j<v2.length; j++){
				v1[i] += tabla[i][j];
				v2[j] += tabla[i][j];
			}
		for(int i=0; i<v1.length; i++)
			System.out.printf("%d  ", v1[i]);
    
    	System.out.println();
    	
		for(int i=0; i<v2.length; i++)
			System.out.printf("%d  ", v2[i]);

    }
}