package EVALUACION1.claseZ;
public class SexagesimoOctavo {

	public static void main(String arg[]){
		char cadena[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '}; 
		char cadena2[] = new char[150];
		int i;
		for(i=0; i<cadena.length; i++)
			cadena2[i] = cadena[i];
			
		for(int j=0; j<cadena.length; j++, i++){
			cadena2[i] = cadena[j];
		}
		
		System.out.print(cadena2);
		
    }
    
    
}