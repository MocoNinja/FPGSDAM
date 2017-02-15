package z;
public class DecimoOctavo {

	public static void main(String ar[]){
		int datos[] = {10, -20, 30, -40, 50, 60};
		for(int i=0; i < datos.length; i++)
			if(datos[i] < 0)
				datos[i] *= -1;
			else
				datos[i] *= 2;
				
		for(int i=0; i < datos.length; i++)
			System.out.printf("%d , ", datos[i]);
    }
    
    
}