package EVALUACION1.claseZ;
public class TrigesimoSexto {

	public static void main(String arcccccc[]){
		int notas[][] = {{7, 9, 3, 8}, {10, 9, 10, 10}, {9, 10, 1, 7}, {3, 10, 5, 6}, {8, 4, 5, 6}};
		String alumnos[] = {"Javier Marías", "Antonio Muñoz", "Isabel Allende", "José Saramago", "Philip Kerr"};
		String asignaturas[] = {"Programación", "Leng. Marcas", "Sistemas", "Bases de datos"};

		System.out.println("LISTADO DE DIECES");
		
		for(int i=0; i<alumnos.length; i++)
			for(int j=0; j<asignaturas.length; j++)
				if(notas[i][j] == 10)
					System.out.printf("%s en %s\n", alumnos[i], asignaturas[j]);
				
				
    }
    
    
}