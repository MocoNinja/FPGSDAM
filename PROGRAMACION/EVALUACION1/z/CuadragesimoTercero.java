package z;
public class CuadragesimoTercero {

	public static void main(String arg[]){
		int vector[] = {25, 2, 73, 81, 16, 4, 33};
		int inter;
		for(int x=0; x<vector.length-1; x++)
			for(int i=vector.length-1; i>x; i--)
				if(vector[i] < vector[i-1]){
					inter = vector[i];
					vector[i] = vector[i-1];
					vector[i-1] = inter;
				}
			
		for(int i=0; i<vector.length; i++)
			System.out.print(vector[i] + " , ");
			
    }
    
    
}