package mio_clase;
/*
* Hacer una tabla de notas
* En las filas hay alumnos (que es un vector aparte, de 5);
* En las columnas estan las asignaturas (que sean 4);
* Sacar el alumno con mejores y peores notas
* Las asignaturas con mejores y peores notas
*/
public class Ej39{
	public static void main(String arg[]){
		String alumnos[] = {"Pepe", "Pepa", "Wenceslao", "Bratislava", "Ebro"};	
		String asignaturas[] = {"Programacion1", "Pogramacion2", "Progamacion3", "Pogamacion4"};
		int notas[][] =  {{7, 9, 3, 8}, {5, 6, 4, 8}, {9, 10, 1, 7}, {10, 10, 10, 10}, {5, 5, 5, 5}};
		int notasTotal[] = {0, 0, 0, 0};
		int notasAlumno[] = {0, 0, 0, 0, 0};
		int alumnoMax = 0, alumnoMin = 0, asignaturaMax = 0, asignaturaMin = 0;
		for (int alumno = 0; alumno < alumnos.length; alumno++){
			for(int asignatura = 0; asignatura < asignaturas.length; ++asignatura){
				notasTotal[asignatura] += notas[alumno][asignatura];
				notasAlumno[alumno] += notas[alumno][asignatura];
				if (notasTotal[asignatura] > notasTotal[asignaturaMax]){
					asignaturaMax = asignatura;
				} 
				if (notasTotal[asignatura] < notasTotal[asignaturaMin]){
					asignaturaMin = asignatura;
				}
			}
			if (notasAlumno[alumno] > notasAlumno[alumnoMax]){
					alumnoMax = alumno;
			}
			if (notasAlumno[alumno] < notasAlumno[alumnoMin]){
					alumnoMin = alumno;
			}
		}
		int pasma = notasTotal[asignaturaMax]/alumnos.length;
		int palmi = notasAlumno[alumnoMin]/asignaturas.length;
		int palma = notasAlumno[alumnoMax]/asignaturas.length;
		int pasmi = notasTotal[asignaturaMin]/alumnos.length;
		System.out.printf("Asignatura con mayor nota media: %s (%d).%nAlumno con mayor nota media: %s (%d).%n", asignaturas[asignaturaMax], pasma, alumnos[alumnoMax], palma);
		System.out.printf("Asignatura con menor nota media: %s (%d).%nAlumno con menor nota media: %s (%d).%n", asignaturas[asignaturaMin], pasmi, alumnos[alumnoMin], palmi);
	}
}