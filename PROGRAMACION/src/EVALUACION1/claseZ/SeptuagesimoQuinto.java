package EVALUACION1.claseZ;
public class SeptuagesimoQuinto {

	public static void main(String arg[]){
		char cadena[] = {'e', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '}; 
		int inicio = 0, fin = 0;
		
		while(fin < cadena.length){
			while(cadena[fin] != ' ')
				fin++;
		
			cadena[inicio] = Character.toUpperCase(cadena[inicio]);
			cadena[fin-1] = Character.toUpperCase(cadena[fin-1]);
		
			inicio = fin + 1;
			fin = inicio +1;
		}
		
		System.out.println(cadena);
		
    }
    
    
}