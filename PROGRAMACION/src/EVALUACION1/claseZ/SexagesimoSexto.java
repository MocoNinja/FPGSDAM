package EVALUACION1.claseZ;
public class SexagesimoSexto {

	public static void main(String arg[]){
		char cadena[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '}; 
		int inicio = 0, fin = 0;

		while(fin < cadena.length){
			while(cadena[fin] != ' ')
				fin++;
			
			//desplazarIzq(cadena, inicio, fin-1);
			desplazarDer(cadena, inicio, fin-1);
			
			inicio = fin + 1;
			fin = inicio +1;
		
		}
		
		System.out.println(cadena);
    }
    
    public static void desplazarIzq(char cad[], int ini, int fin){
    	char primero = cad[ini];
		for(int i=ini+1; i<=fin; i++)
			cad[i-1] = cad[i];
    	cad[fin] = primero;
	}
	
    public static void desplazarDer(char cad[], int ini, int fin){
    	char ultimo = cad[fin];
		for(int i=fin-1; i>=ini; i--)
			cad[i+1] = cad[i];
    	cad[ini] = ultimo;
	}
    
}