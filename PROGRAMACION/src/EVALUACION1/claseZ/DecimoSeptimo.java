package EVALUACION1.claseZ;
public class DecimoSeptimo {

	public static void main(String ar[]){
		int datos[] = {10, 20, 30, 40, 50, 60};
		int inter;
		for(int i=0; i < (datos.length / 2); i++){
			inter = datos[datos.length-1-i];
			datos[datos.length-1-i] = datos[i];
			datos[i] = inter;
		}
		for(int i=0; i < datos.length; i++)
			System.out.printf("%d , ", datos[i]);
		
    }
    
    
}