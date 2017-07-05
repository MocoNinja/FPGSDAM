package EVALUACION1.claseZ;
public class VigesimoSeptimo {

	public static void main(String arcccccc[]){
		int tabla[][] = {{10, 20, -30, -40}, {50, 60, -70, 80}, {90, 100, -110, 120}};
		for(int i=0; i<tabla.length; i++){
			for(int j=0; j<tabla[i].length; j++)
				if(tabla[i][j] < 0)
					tabla[i][j] *= -1;
				else
					tabla[i][j] *= 5;
		}			
					
		for(int i=0; i<tabla.length; i++){
			for(int j=0; j<tabla[i].length; j++)
				System.out.printf("%d  ", tabla[i][j]);
			System.out.println();
		}
	}
}
