package EVALUACION1.claseZ;
public class QuincuagesimoSegundo {

	public static void main(String arcccccc[]){
		int elem1 = 5;
		int elem2 = 2;
		int combinatoria = (factorial(elem1) / factorial(elem1-elem2)) / factorial(elem2);
		System.out.printf("Combinaciones de %d elementos tomados de %d en %d es %d", elem1, elem2, elem2, combinatoria);
		
    }
    
    public static int factorial(int f){
    	int acum = 1;
    	for(int i=1; i<=f; i++)
    		acum *= i;
    	return acum;
    }
    
}