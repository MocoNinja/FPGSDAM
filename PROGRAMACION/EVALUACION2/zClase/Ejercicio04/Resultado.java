package zClase.Ejercicio04;
public class Resultado {
	static private int resultado[][];
	static Bombo bombo;
    public static void main(String args[]) {
    	resultado = new int[6][8];
    	bombo = new Bombo();
    	rellenar();
    	imprimir();
    }
    public static void rellenar(){
    	for(int i=0; i<6; i++)
    		for(int j=0; j<8; j++)
    			resultado[i][j] = bombo.sacaBola();
    }
    public static void imprimir(){
    	for(int i=0; i<6; i++){
			System.out.println();
    		for(int j=0; j<8; j++)
    			System.out.printf(" %d    ", resultado[i][j]);
    	}    			
    }
    
}