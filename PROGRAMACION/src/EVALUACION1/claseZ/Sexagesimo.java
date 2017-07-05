package EVALUACION1.claseZ;
public class Sexagesimo {

	public static void main(String arcccccc[]){
		char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'}; 
		char fraseMod[] = new char[50];
		char fraseMod2[] = modificarFrase2(frase);
		modificarFrase(frase, fraseMod);
		System.out.print(fraseMod);
		System.out.println();
		System.out.print(fraseMod2);
    }
    
    public static void modificarFrase(char[] f1, char[] f2){
    	int i, i2;
    	for(i=0, i2=0; i<f1.length; i++, i2++){
    		if(f1[i] == ' '){
    			f2[i2] = 'x';
				i2++;
    		} 
    		f2[i2] = f1[i];
    	}
    	f2[i2] = 'x';
    	f2[i2+1] = '\0';
    }
    
    public static char[] modificarFrase2(char[] f1){
    	char[] f2 = new char[100];
    	for(int i=0, i2=0; i<f1.length; i++, i2++){
    		if(f1[i] == ' '){
    			f2[i2] = 'x';
				i2++;
    		} 
    		f2[i2] = f1[i];
    	}
    	return f2;
    }
    
}