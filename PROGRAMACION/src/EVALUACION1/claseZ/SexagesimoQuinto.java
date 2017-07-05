package EVALUACION1.claseZ;
public class SexagesimoQuinto {

	public static void main(String arg[]){
		char cadena[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '}; 
		int inicio = 0, fin = 0;

		while(fin < cadena.length){
			while(cadena[fin] != ' ')
				fin++;
			
			intercambiar(cadena, inicio, fin-1);
			
			inicio = fin + 1;
			fin = inicio +1;
		
		}
		
		System.out.println(cadena);
    }
    
    public static void intercambiar(char cad[], int ini, int fin){
    	char inter;
		inter = cad[ini];
		cad[ini] = cad[fin];
		cad[fin] = inter;
    
	}
}