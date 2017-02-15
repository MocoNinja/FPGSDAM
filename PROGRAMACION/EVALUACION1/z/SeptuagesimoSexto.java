package z;
public class SeptuagesimoSexto {

	public static void main(String arg[]){
		char cadena[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '}; 

		System.out.println(cadena);
		for(int i=0; i<cadena.length; i++)
			switch (cadena[i]) {
	            case 'A': case 'E': case 'I': case 'O': case 'U':    
	            		cadena[i] = Character.toLowerCase(cadena[i]);
	            		break;
				case 'a': case 'e': case 'i': case 'o': case 'u':
	            		cadena[i] = Character.toUpperCase(cadena[i]);
	            		break;		
            	default:
						cadena[i] = '$';
			}
		System.out.println(cadena);
    }
    
    
}