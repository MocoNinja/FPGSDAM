package EVALUACION1.claseZ;
public class VigesimoCuarto {

	public static void main(String arcccccc[]){
		int datos[] = {10, -20, 30, -40, 50, 60, 73};
		int multiplos[] = {3, 5, 7};
		
		for(int i=0; i<multiplos.length; i++){
			for(int j=0; j<datos.length; j++)
				System.out.printf("%d , ", (datos[j] * multiplos[i]));
			System.out.println();
		}
			
		
    }
    
    
}