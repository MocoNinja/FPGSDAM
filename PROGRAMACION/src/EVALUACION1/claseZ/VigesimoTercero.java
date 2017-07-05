package EVALUACION1.claseZ;
public class VigesimoTercero {

	public static void main(String ar[]){
		int datos[] = {10, -20, 30, -40, 50, 60, 73};
		
		
		for(int x=0; x < datos.length; x++){
			int guardar = datos[datos.length-1];
			for(int i=datos.length-1; i>0; i--)
				datos[i] = datos[i-1];
			datos[0] = guardar;
			for(int i=0; i<datos.length; i++)
				System.out.printf("%d , ", datos[i]);
			System.out.println();
		}	
			
    }
    
    
}