package z;
public class QuincuagesimoQuinto {

	public static void main(String arcccccc[]){
		int kilos[][] = {{5, 6, 9, 23, 7, 14, 0}, {16, 8, 4, 33, 15, 21, 2}};
		int precio[] = {6, 7};
		modificar(kilos, precio);
    	for(int i=0; i<kilos.length; i++){
    		for(int j=0; j<kilos[i].length; j++)
    			System.out.printf("%d  ", kilos[i][j]);
    		System.out.println();
    	}
    }
    
    public static void modificar(int[][] v, int p[]){
    	for(int i=0; i<v.length; i++)
    		for(int j=0; j<v[i].length; j++)
    			v[i][j] *= p[i];
    }
    
}