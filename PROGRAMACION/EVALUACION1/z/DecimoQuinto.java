package z;
public class DecimoQuinto {

	public static void main(String ar[]){
		int datos[] = {-17, -55, -33, -1, -44};
		int maximo = 0;
		int posmax = 0;
		for(int i=0; i<datos.length; i++)
			if(datos[i] > maximo)
				maximo = datos[i];
		System.out.printf("El valor máximo es : %d\n", maximo);
		
		maximo = datos[0];
		for(int i=1; i<datos.length; i++)
			if(datos[i] > maximo)
				maximo = datos[i];
		System.out.printf("El valor máximo es : %d\n", maximo);
		
		
		for(int i=1; i<datos.length; i++)
			if(datos[i] > datos[posmax])
				posmax = i;
		System.out.printf("El valor máximo es : %d\n", datos[posmax]);					
    }
    
    
}