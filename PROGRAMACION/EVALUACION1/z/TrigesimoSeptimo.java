package z;
public class TrigesimoSeptimo {

	public static void main(String arcccccc[]){
		int salarios[][] = {{700, 900, 1300, 800, 790, 850}, {1000, 950, 1080, 1070, 1200, 1100}, {1300, 930, 1280, 1170, 1000, 1000}, {1500, 1950, 1880, 1970, 2200, 2100}};
		String empleados[] = {"Javier Marías", "Antonio Muñoz", "Isabel Allende", "Gabriel García"};
		String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"};
		int empleadosAcum[] = {0, 0, 0, 0};
		int mesesAcum[] = {0, 0, 0, 0, 0, 0};
		int posmaxEmp=0, posminEmp=0;
		int posmaxMes=0, posminMes=0;
		
		for(int i=0; i<empleados.length; i++)
			for(int j=0; j<meses.length; j++){
				empleadosAcum[i] += salarios[i][j];
				mesesAcum[j] += salarios[i][j];
			}
		
		for(int i=0; i<empleados.length; i++){
			if(empleadosAcum[i] > empleadosAcum[posmaxEmp])
				posmaxEmp = i;
			if(empleadosAcum[i] < empleadosAcum[posminEmp])
				posminEmp = i;
		}	
		
		System.out.printf("El empleado que más cobra es %s con una media de %d euros al mes\n", empleados[posmaxEmp], empleadosAcum[posmaxEmp] / meses.length);
		System.out.printf("El empleado que menos cobra es %s con una media de %d euros al mes\n\n", empleados[posminEmp], empleadosAcum[posminEmp] / meses.length);
		
		for(int i=0; i<meses.length; i++){
			if(mesesAcum[i] > mesesAcum[posmaxMes])
				posmaxMes = i;
			if(mesesAcum[i] < mesesAcum[posminMes])
				posminMes = i;
		}
		
		System.out.printf("El mes que más se cobra es %s con una media de %d euros al mes\n", meses[posmaxMes], mesesAcum[posmaxMes] / empleados.length);
		System.out.printf("El menos que menos se cobra es %s con una media de %d euros al mes", meses[posminMes], mesesAcum[posminMes] / empleados.length);
		
    }
    
    
}