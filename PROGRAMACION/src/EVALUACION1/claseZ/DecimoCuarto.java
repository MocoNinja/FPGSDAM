package EVALUACION1.claseZ;
public class DecimoCuarto {

	public static void main(String ar[]){
		int datos[] = {17, 55, 33, 21, 44};
		int i;
		for(i=0; i<5; i++)
			System.out.printf("datos[%d] = %d\n", i, datos[i]);
		
		System.out.println();
		
		//Bucle para modificar el contenido de datos
		for(i=0; i<5; i++)
			datos[i] = datos[i] * 2;  // datos[i] *= 2;
		
		//Bucle para que veamos el contenido de datos modificado	
		for(i=0; i<5; i++)
			System.out.printf("datos[%d] = %d\n", i, datos[i]);
    }
    
}