package z;
public class Quincuagesimo {

	public static void main(String arcccccc[]){
		int vector[] = {25, 2, 73, 81, 16, 4, 33};
		ordenar(vector);
		for(int i=0; i<vector.length; i++)
			System.out.print(vector[i] + " , ");
		
    }
    
    public static void ordenar(int[] v){
		int inter;
		for(int x=0; x<v.length-1; x++)
			for(int i=v.length-1; i>x; i--)
				if(v[i] < v[i-1]){
					inter = v[i];
					v[i] = v[i-1];
					v[i-1] = inter;
				}    	
    }
    
}