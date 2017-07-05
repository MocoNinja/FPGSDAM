package EVALUACION1.claseZ;
public class CuadragesimoNoveno {

	public static void main(String arcccccc[]){
		int salarios[][] = {{700, 900, 1300, 800, 790, 850}, {1000, 950, 1080, 1070, 1200, 1100}, {1300, 930, 1280, 1170, 1000, 1000}, {1500, 1950, 1880, 1970, 2200, 2100}};
		String empleados[] = {"Javier Marías", "Antonio Muñoz", "Isabel Allende", "Gabriel García"};
		String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"};
		int empleadosAcum[] = {0, 0, 0, 0};
		int emplAcum[] = salariosSemestrales(salarios);
		salariosSemestrales2(salarios, empleadosAcum);
		for(int i=0; i<empleados.length; i++)
			System.out.println(empleados[i] + " cobró " + emplAcum[i]);
		for(int i=0; i<empleados.length; i++)
			System.out.println(empleados[i] + " cobró " + empleadosAcum[i]);		
		
		
		int salariosPorMes[] = mesesSalario(salarios);
		for(int i=0; i<meses.length; i++)
			System.out.println(meses[i] + " se pagó " + salariosPorMes[i]);
		
		int mesesAcum[] = {0, 0, 0, 0, 0, 0};
		mesesSalario2(salarios, mesesAcum);
		for(int i=0; i<meses.length; i++)
			System.out.println(meses[i] + " se pagó " + mesesAcum[i]);		
			
    }
    
    public static int[] salariosSemestrales(int[][] sueldos){
    	int empleadosAcum[] = {0, 0, 0, 0};
    	for(int i=0; i<sueldos.length; i++)
			for(int j=0; j<sueldos[i].length; j++)
				empleadosAcum[i] += sueldos[i][j];
		return empleadosAcum;		
    }
    public static void salariosSemestrales2(int[][] sueldos, int emplAcum[]){
    	for(int i=0; i<sueldos.length; i++)
			for(int j=0; j<sueldos[i].length; j++)
				emplAcum[i] += sueldos[i][j];		
    }
    
    
     public static int[] mesesSalario(int[][] sueldos){
    	int mesesAcum[] = {0, 0, 0, 0, 0, 0};
    	for(int j=0; j<mesesAcum.length; j++)
			for(int i=0; i<sueldos.length; i++)
				mesesAcum[j] += sueldos[i][j];
		return mesesAcum;		
    }
    
    public static void mesesSalario2(int[][] sueldos, int[] mesesAcum){
    	for(int j=0; j<mesesAcum.length; j++)
			for(int i=0; i<sueldos.length; i++)
				mesesAcum[j] += sueldos[i][j];	
    }
}