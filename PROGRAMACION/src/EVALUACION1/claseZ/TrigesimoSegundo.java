package EVALUACION1.claseZ;
public class TrigesimoSegundo {

	public static void main(String arcccccc[]){
		int salas[][] = {{10, 20, 30, 40, 150, 230, 243}, {50, 60, 70, 80, 175, 200, 170}, {90, 100, 110, 120, 130, 125, 110}, {30, 110, 50, 120, 130, 225, 153}};
		String dias[] = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
		int vacum[] = {0, 0, 0, 0, 0, 0, 0};
		int posmax=0, posmin=0;
		for(int j=0; j<dias.length; j++)
			for(int i=0; i<salas.length; i++)
				vacum[j] += salas[i][j];
		
		for(int i=1; i<vacum.length; i++){
			if(vacum[i] > vacum[posmax])
				posmax = i;
			if(vacum[i] < vacum[posmin])
				posmin = i;
		}
		
		System.out.printf("El %s fue el mejor día, con %d entradas vendidas\n", dias[posmax], vacum[posmax]);
		System.out.printf("El %s fue el peor día, con %d entradas vendidas\n", dias[posmin], vacum[posmin]);
	}
}
 