package mio_clase;
/*
* Con la misma estructura del Ej39
* Mostrar la cantidad de dieces
* El nombre de la persona que ha sacado el 10 y en que asignatura
* Ej:
* 10's de clase:
* Pepe: FOL
* Pepe: Programacion
* Santi: Marcas
*/


public class Ej40{
	public static void main(String arg[]){
		String alumnos[] = {"Pepe", "Pepa", "Wenceslao", "Bratislava", "Ebro"};	
		String asignaturas[] = {"Programacion1", "Pogramacion2", "Progamacion3", "Pogamacion4"};
		int notas[][] =  {{7, 9, 3, 8}, {5, 6, 4, 8}, {9, 10, 1, 7}, {10, 10, 10, 10}, {5, 5, 5, 5}};
		System.out.println("Dieces de clase:");
		for (int alumno = 0; alumno < alumnos.length; alumno++){
			for(int asignatura = 0; asignatura < asignaturas.length; ++asignatura){
				if (notas[alumno][asignatura] == 10){
					System.out.printf("%s: %s\n",alumnos[alumno], asignaturas[asignatura]);
				}
			}
		}	
	}
}	