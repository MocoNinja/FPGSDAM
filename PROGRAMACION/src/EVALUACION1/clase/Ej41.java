package EVALUACION1.clase;
/*
* Sacar quien cobra mas menos
* En que mes se cobra mas menos
* Sacar la media por mes y empleado
*/
public class Ej41{
	public static void main(String arg[]){
		String empleados[] = {"Pepe", "Maria", "Juan", "Maria Esmeralda"};
		String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"};
		int sueldos[][] = {{1000,1000,1000,1000,1000,1000},{2000,2500,2000,0,0,0},{2000,1000,20,10000,0,2313424},{1,1,1,1,1,1}};
		int sueldoEmpleados[] = {0, 0, 0, 0, 0};
		int sueldoMes[] = {0,0,0,0,0,0};
		int sueldoMaxEmp = 0, sueldoMinEmp = 0, sueldoMaxMes = 0, sueldoMinMes = 0;
		for ( int empleado = 0; empleado < empleados.length; ++empleado){
			for (int mes = 0; mes < meses.length; ++mes){
				sueldoEmpleados[empleado] += sueldos[empleado][mes];
				sueldoMes[mes] += sueldos[empleado][mes];
				if (sueldoMes[mes] > sueldoMes[sueldoMaxMes]){
					sueldoMaxMes = mes;
				}
				if (sueldoMes[mes] < sueldoMes[sueldoMinMes]){
					sueldoMinMes = mes;
				}
			}
				if (sueldoEmpleados[empleado] > sueldoEmpleados[sueldoMaxEmp]){
					sueldoMaxEmp = empleado;
				}
				if (sueldoEmpleados[empleado] < sueldoEmpleados[sueldoMinEmp]){
					sueldoMinEmp = empleado;
				}
		}
		System.out.printf("El empleado que más cobra es: %s%n", empleados[sueldoMaxEmp]);
		System.out.printf("Sueldo medio = %d%n", sueldoEmpleados[sueldoMaxEmp]/empleados.length);
		System.out.printf("El empleado que menos cobra es: %s%n", empleados[sueldoMinEmp]);
		System.out.printf("Sueldo medio = %d%n", sueldoEmpleados[sueldoMinEmp]/empleados.length);
		System.out.printf("El mes en que más se cobra es: %s%n", meses[sueldoMaxMes]);
		System.out.printf("Sueldo medio = %d%n", sueldoMes[sueldoMaxMes]/meses.length);
		System.out.printf("El mes en que menos se cobra es: %s%n", meses[sueldoMinMes]);
		System.out.printf("Sueldo medio = %d%n", sueldoMes[sueldoMinMes]/meses.length);
	}
}