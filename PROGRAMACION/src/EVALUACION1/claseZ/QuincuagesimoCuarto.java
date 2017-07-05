package EVALUACION1.claseZ;
public class QuincuagesimoCuarto {

	public static void main(String arcccccc[]){
		int tabla1[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		int multiplicador = 4; 
		modificar(tabla1, multiplicador);
    	for(int i=0; i<tabla1.length; i++){
    		for(int j=0; j<tabla1[i].length; j++)
    			System.out.printf("%d  ", tabla1[i][j]);
    		System.out.println();
    	}
		
		
    }
    
    public static void modificar(int[][] v, int m){
    	for(int i=0; i<v.length; i++)
    		for(int j=0; j<v[i].length; j++)
    			v[i][j] *= m;
    }
    
}