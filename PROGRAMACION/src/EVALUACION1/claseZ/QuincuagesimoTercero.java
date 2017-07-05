package EVALUACION1.claseZ;
public class QuincuagesimoTercero {

	public static void main(String arg[]){
		int salarios[][] = {{700, 900, 1300, 800, 790, 850}, {1000, 950, 1080, 1070, 1200, 1100}, {1300, 930, 1280, 1170, 1000, 1000}, {1500, 1950, 1880, 1970, 2200, 2100}};
		String empleados[] = {"Javier Marías", "Antonio Muñoz", "Isabel Allende", "Gabriel García"};
		
		for(int i=0; i<empleados.length; i++)
			System.out.printf("El empleado %s ha ganado %d\n", empleados[i], suma(salarios[i]));
		
    }
    
    public static int suma (int v[]){
    	int acum = 0;
    	for(int i=0; i<v.length; i++)
    		acum += v[i];
    	return acum;
    }
    
}