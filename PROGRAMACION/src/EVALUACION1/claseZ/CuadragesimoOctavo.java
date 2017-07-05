package EVALUACION1.claseZ;
public class CuadragesimoOctavo {

	public static void main(String arg[]){
		int salarios[][] = {{700, 900, 1300, 800, 790, 850}, {1000, 950, 1080, 1070, 1200, 1100}, {1300, 930, 1280, 1170, 1000, 1000}, {1500, 1950, 1880, 1970, 2200, 2100}};
		
		int suma = suma(salarios);
		System.out.println("La suma de todos los elementos es " + suma);
		
    }
    
    
    public static int suma(int tabla[][]){
    	int acum = 0;
    	for(int i=0; i<tabla.length; i++)
    		for(int j=0; j<tabla[i].length; j++)
    			acum += tabla[i][j];
    	return acum;
    }
    
}