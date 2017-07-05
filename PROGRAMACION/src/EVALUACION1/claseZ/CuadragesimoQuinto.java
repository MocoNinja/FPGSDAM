package EVALUACION1.claseZ;
public class CuadragesimoQuinto {

	public static void main(String arg[]){
		int vector[] = {25, 2, 73, 81, 16, 4, 33};
		int inter, i;
		for(int x=1; x<vector.length; x++){
			i=x;
			while((i > 0) && (vector[i] < vector[i-1])){
				inter = vector[i];
				vector[i] = vector[i-1];
				vector[i-1] = inter;
				i--;
			}
		}
				
		for(i=0; i<vector.length; i++)
			System.out.print(vector[i] + " , ");
		
    }
    
    
}