package z;
public class QuincuagesimoNoveno {

	public static void main(String arcccccc[]){
		char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'}; 
		
		System.out.printf("Número de palabras: %d", numEspacios(frase)+1);
    }
    
    public static int numEspacios(char[] cs){
    	int cont = 0;
    	for(int i=0; i < cs.length; i++)
    		if(cs[i] == ' ')
    			cont++;
    	return cont;
    }
}