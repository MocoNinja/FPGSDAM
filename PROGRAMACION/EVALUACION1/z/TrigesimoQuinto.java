package z;
public class TrigesimoQuinto {

	public static void main(String arcccccc[]){
		int notas[][] = {{7, 9, 3, 8}, {10, 9, 9, 8}, {9, 10, 1, 7}, {3, 10, 5, 6}, {8, 4, 5, 6}};
		String alumnos[] = {"Javier Marías", "Antonio Muñoz", "Isabel Allende", "José Saramago", "Philip Kerr"};
		String asignaturas[] = {"Programación", "Leng. Marcas", "Sistemas", "Bases de datos"};
		int alumnosAcum[] = {0, 0, 0, 0, 0};
		int asignaturasAcum[] = {0, 0, 0, 0};
		int posmaxAl=0, posminAl=0;
		int posmaxAs=0, posminAs=0;
		
		for(int i=0; i<alumnos.length; i++)
			for(int j=0; j<asignaturas.length; j++){
				alumnosAcum[i] += notas[i][j];
				asignaturasAcum[j] += notas[i][j];
			}
				
		for(int i=0; i<alumnos.length; i++){
			if(alumnosAcum[i] > alumnosAcum[posmaxAl])
				posmaxAl = i;
			if(alumnosAcum[i] < alumnosAcum[posminAl])
				posminAl = i;
		}
		
		System.out.printf("El alumno con mejores notas es %s, con una media de %d\n", alumnos[posmaxAl], alumnosAcum[posmaxAl]/asignaturas.length);
		System.out.printf("El alumno con peores notas es %s, con una media de %d\n", alumnos[posminAl], alumnosAcum[posminAl]/asignaturas.length);
	
		
		for(int i=0; i<asignaturas.length; i++){
			if(asignaturasAcum[i] > asignaturasAcum[posmaxAs])
				posmaxAs = i;
			if(asignaturasAcum[i] < asignaturasAcum[posminAs])
				posminAs = i;
		}
		
		System.out.printf("La asignatura con mejores notas es %s, con una media de %d\n", asignaturas[posmaxAs], asignaturasAcum[posmaxAs]/alumnos.length);
		System.out.printf("La asignatura con peores notas es %s, con una media de %d\n", asignaturas[posminAs], asignaturasAcum[posminAs]/alumnos.length);
		
    }

}