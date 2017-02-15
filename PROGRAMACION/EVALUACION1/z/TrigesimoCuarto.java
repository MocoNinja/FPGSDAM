package z;
public class TrigesimoCuarto {

	public static void main(String arcccccc[]){
		int salas[][] = {{10, 20, 30, 40, 150, 230, 243}, {50, 60, 70, 80, 175, 250, 170}, {90, 100, 110, 120, 130, 125, 110}, {30, 110, 50, 120, 130, 225, 153}};
		String peliculas[] = {"El resplandor", "Tortugas Ninja", "Ave César", "El juez"};
		String dias[] = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
		int posmaxF=0, posmaxC=0, posminF=0, posminC=0;
		
		for(int i=0; i<peliculas.length; i++)
			for(int j=0; j<dias.length; j++){
				if(salas[i][j] > salas[posmaxF][posmaxC]){
					posmaxF = i;
					posmaxC = j;
				}
				if(salas[i][j] < salas[posminF][posminC]){
					posminF = i;
					posminC = j;
				}
			}
		
		System.out.printf("%s el %s tuvo máxima audiencia con %d espectadores\n", peliculas[posmaxF], dias[posmaxC], salas[posmaxF][posmaxC]);
		System.out.printf("%s el %s tuvo la menor audiencia con %d espectadores\n", peliculas[posminF], dias[posminC], salas[posminF][posminC]);
			
    }
    
    
}