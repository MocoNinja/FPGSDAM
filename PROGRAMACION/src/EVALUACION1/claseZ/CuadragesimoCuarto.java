package EVALUACION1.claseZ;
public class CuadragesimoCuarto {

	public static void main(String arg[]){
		int vector[] = {25, 2, 73, 81, 16, 4, 33};
		int inter;
		int posmin = 0;
		for(int x=0; x<vector.length-1; x++){
			for(int i=x; i<vector.length; i++)
				if(vector[posmin] > vector[i])
					posmin = i; 
			inter = vector[posmin];
			vector[posmin] = vector[x];
			vector[x] = inter;
		}		
		
		for(int i=0; i<vector.length; i++)
			System.out.print(vector[i] + " , ");
    }
    
    
}