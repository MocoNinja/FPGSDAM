package z;
public class DecimoNoveno {

	public static void main(String ar[]){
		float datos[] = {10, -20, 30, -40, 50, 60, 73};
		float acum = 0;
		float media;
		for(int i=0; i<datos.length; i++)
			acum += datos[i];
		media = acum / datos.length;
		System.out.printf("La media es %.2f \n", media);
		
		for(int i=0; i<datos.length; i++)
			if(datos[i] > media)
				System.out.printf("%.2f supera la media \n", datos[i]);
    }
    
    
}