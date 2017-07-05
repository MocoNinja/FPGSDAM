package EVALUACION1.claseZ;
public class SexagesimoSeptimo {

	public static void main(String arg[]){
		char cadena[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '}; 
		char caracter = 'a';
		char subcadena[] = {'A', 'B', 'C', 'D', 'E'};
		char cadena2[] = new char[150];
	
		int j = 0;
		for(int i=0; i<cadena.length; i++){
			if(cadena[i] != 'a'){
				cadena2[j] = cadena[i];
				j++;
			}else{
				for(int x=0; x<subcadena.length; x++){
					cadena2[j] = subcadena[x];
					j++;
				}
			}
		}			
		
		System.out.println(cadena2);
		
    }
    
    
}