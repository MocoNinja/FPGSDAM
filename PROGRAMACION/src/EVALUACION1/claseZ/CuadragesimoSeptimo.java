package EVALUACION1.claseZ;
public class CuadragesimoSeptimo {

	public static void main(String arg[]){
		int vector[] = {23, 45, 65, 12, 7, 123, 16, 50};
		int vector2[] = {233, 454, 685, 12, 78, 123, 16, 50};
		
		int maxvalor = maximo(vector);
		System.out.println("El máximo es " + maxvalor);
		
		System.out.println("El máximo del segundo es " + maximo(vector2));
    }
    
    public static int maximo(int v[]){
    	int posmax = 0;
    	for(int i=0; i<v.length; i++)
    		if(v[posmax] < v[i])
    			posmax = i;
    	return v[posmax];
    }
    
}