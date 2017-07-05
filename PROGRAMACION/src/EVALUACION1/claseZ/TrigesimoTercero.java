package EVALUACION1.claseZ;
public class TrigesimoTercero {

	public static void main(String arcccccc[]){
		int salas[][] = {{10, 20, 30, 40, 150, 230, 243}, {50, 60, 70, 80, 175, 200, 170}, {90, 100, 110, 120, 130, 125, 110}, {30, 110, 50, 120, 130, 225, 153}};
		String peliculas[] = {"El resplandor", "Tortugas Ninja", "Ave César", "El juez"};
		int vacum[] = {0, 0, 0, 0};
		int posmax=0, posmin=0;
		for(int i=0; i<salas.length; i++)
			for(int j=0; j<salas[i].length; j++)
				vacum[i] += salas[i][j];
		
		for(int i=1; i<vacum.length; i++){
			if(vacum[i] > vacum[posmax])
				posmax = i;
			if(vacum[i] < vacum[posmin])
				posmin = i;
		}
		
		System.out.printf("La película %s fue la más vista, con %d entradas vendidas\n", peliculas[posmax], vacum[posmax]);
		System.out.printf("La película %s fue la menos vista, con %d entradas vendidas\n", peliculas[posmin], vacum[posmin]);
		
    }
    
    
}