package EVALUACION1.claseZ;
public class QuincuagesimoSexto {

	public static void main(String arcccccc[]){
		int kilos[][] = {{5, 6, 9, 23, 7, 14, 0}, {16, 8, 4, 33, 15, 21, 2}};
		int precio[] = {6, 7};
		int ventas[][];
		ventas = crearVentas(kilos, precio);

    	for(int i=0; i<kilos.length; i++){
    		for(int j=0; j<kilos[i].length; j++)
    			System.out.printf("%d  ", kilos[i][j]);
    		System.out.println();
    	}
    	
    	for(int i=0; i<ventas.length; i++){
    		for(int j=0; j<ventas[i].length; j++)
    			System.out.printf("%d  ", ventas[i][j]);
    		System.out.println();
    	}
    }
    
    public static int[][] crearVentas(int[][] v, int p[]){
		int[][] resultado = new int[2][7];
    	for(int i=0; i<v.length; i++)
    		for(int j=0; j<v[i].length; j++)
    			resultado[i][j] = v[i][j] * p[i];
    			
    	return resultado;
    }    
    
}