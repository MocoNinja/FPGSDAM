package z;
public class SexagesimoCuarto {

	public static void main(String arg[]){
		char cadena[] = {'E', 'n', ' ', 'u', 'n', ' ', 'n', 'n', 'n', 'n', 'r', ' ', 'n', 'n', 'n', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '}; 
		char subcadena[] = {'r', 'r', 'r'};
		
		System.out.println("Número de veces encontrada = " + contener(cadena, subcadena));
		
    }
    
    public static int contener(char cad[], char sub[]){
    	int cont = 0;
    	int i; 
    	int i2;
	    int j;
    	for(int pral = 0; pral < (cad.length - sub.length); pral++){
    		i = pral;
	    	while((i<cad.length) && (cad[i] != sub[0]))
	    		i++;
	    	if(cad[i] == sub[0]){
	    		pral = i;
	    		i2 = i+1;
	    		j = 1;
	    		while((j < sub.length) && (cad[i2] == sub[j])){
	    			i2++;
	    			j++;
	    		}
	    		if(j == sub.length)
	    			cont++;
	    	}
    	}    		
    		
    	return cont;
    }
}