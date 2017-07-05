package EVALUACION1.claseZ;
public class QuincuagesimoSeptimo {

	public static void main(String arcccccc[]){
		int kilos[][] = {{5, 6, 9, 23, 7, 14, 0}, {16, 8, 4, 33, 15, 21, 2}};
		String productos[] = {"Peras", "Manzanas"};
		int sumaDeKilos[] = sumaKilos(kilos);
		
		for(int i=0; i<sumaDeKilos.length; i++)
			System.out.printf("Hemos vendido %d kilos de %s\n", sumaDeKilos[i], productos[i] );
    }
    
    public static int[] sumaKilos(int k[][]){
    	int sk[] = {0, 0};
    	for(int i=0; i<k.length; i++)
    		for(int j=0; j<k[i].length; j++)
    			sk[i] += k[i][j];
    	return sk;
    }
}