package EVALUACION1.claseZ;
public class SexagesimoNoveno {

	public static void main(String arg[]){
		char cadena[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '}; 
		char cadena2[] = new char[150];
	
		for(int i=(cadena.length-1), j=0; i>=0; i--, j++)
			cadena2[j] = cadena[i];
			
		System.out.println(cadena2);
	
    }
    
    
}