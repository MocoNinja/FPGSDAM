package EVALUACION1.claseZ;
public class SexagesimoSegundo {

	public static void main(String arg[]){
		char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'}; 
		char sustituir = 'a';
		char sustituto = 'X';
		sustitucion(frase, sustituir, sustituto);
		System.out.print(frase);
    }
    
    public static void sustitucion(char[] fr, char s1, char s2){
    	for(int i=0; i<fr.length; i++)
    		if(fr[i] == s1)
    			fr[i] = s2;
    }
}