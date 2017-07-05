package EVALUACION1.claseZ;
public class QuincuagesimoOctavo {

	public static void main(String arcccccc[]){
		int kilos[][] = {{5, 6, 9, 23, 7, 14, 0}, {16, 8, 4, 33, 15, 21, 2}};
		int multiplicador = 5;
		
		modificar(kilos, multiplicador);
		
    	for(int i=0; i<kilos.length; i++){
    		for(int j=0; j<kilos[i].length; j++)
    			System.out.printf("%d  ", kilos[i][j]);
    		System.out.println();
    	}
		
    }
    
    public static void modificar(int kilos[][], int m){
    	for(int i=0; i<kilos.length; i++)
    		for(int j=0; j<kilos[i].length; j++)
    			if(kilos[i][j] < 10)
    				kilos[i][j] *= m;
    }
    
}