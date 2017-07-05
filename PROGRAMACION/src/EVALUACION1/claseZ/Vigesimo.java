package EVALUACION1.claseZ;
public class Vigesimo {

	public static void main(String ar[]){
		int datos[] = {10, -20, 30, -40, 50, 60, 73};
		int guardar = datos[0];
		for(int i=1; i<datos.length; i++)
			datos[i-1] = datos[i];
		datos[datos.length-1] = guardar;
		
		for(int i=0; i<datos.length; i++)
			System.out.printf("%d , ", datos[i]);
    }
    
    
}