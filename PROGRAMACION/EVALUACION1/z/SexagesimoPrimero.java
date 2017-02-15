package z;
public class SexagesimoPrimero {

	public static void main(String arcccccc[]){
		char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'}; 
		aMayusculas(frase);
		System.out.println(frase);
	
    }
    
    public static void aMayusculas(char[] f){
    	for(int i=0; i<f.length; i++)
    		f[i] = Character.toUpperCase(f[i]);
    }
}