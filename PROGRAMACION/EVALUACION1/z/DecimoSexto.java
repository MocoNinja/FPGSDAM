package z;
public class DecimoSexto {

	public static void main(String ar[]){
		int datos[] = {-17, -55, -33, -1, -44};
		int maximo = datos[0], minimo = datos[0];
		int posmax = 0, posmin = 0;
		
		for(int i=1; i<datos.length; i++){
			if(datos[i] > maximo)
				maximo = datos[i];
			if(datos[i] < minimo)
				minimo = datos[i];
		}
		System.out.printf("El valor máximo es : %d y el mínimo es : %d", maximo, minimo);
		
		for(int i=1; i<datos.length; i++){
			if(datos[i] > datos[posmax])
				posmax = i;
			if(datos[i] < datos[posmin])
				posmin = i;
		}
		System.out.printf("El valor máximo es : %d y el mínimo es : %d", datos[posmax], datos[posmin]);
		
    }
    
    
}