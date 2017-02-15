package z;
public class SexagesimoTercero {

	public static void main(String arg[]){
		char sustituir = 'n';
		char sustituto[] = {'X', 'X'};
		char frase[] = new char[100];
		char frase2[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'}; 
		for(int i=0; i<frase2.length; i++)
			frase[i] = frase2[i];
			
		sustitucion(frase, sustituir, sustituto, frase2.length);
		System.out.print(frase);
    }
    
    public static void sustitucion(char fr[], char s1, char[] s2, int longitud){
    	
    	for(int i=0; i<longitud; i++)
    		if(fr[i] == s1){
		    	for(int j=longitud-1; j>=i; j--)
    				fr[j+1] = fr[j];
    			longitud++;
    			fr[i] = s2[0];
    			fr[++i] = s2[1];
    		}
    }
    
}