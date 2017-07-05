package EVALUACION1.clase;
//Poner cadena en cadena2 con las palabras en orden inverso

public class Setentaytres {
 	public static void main(String[] arcccccc) {
     
    	char cadena2[] = new char[150];
    	char cadena[] = {' ','E','n',' ','u','n',' ','l','u','g','a','r',' ','d','e',' ','L','a',' ','M','a','n','c','h','a'};	
    	invertirpalabras(cadena,cadena2);
     	System.out.print(cadena2);
     }
    
     public static void invertirpalabras(char[] cadena, char[] cadena2) {
	
		int fin=cadena.length-1;
		int inicio=fin;
		int j=0;
		while(inicio>0){
			while(cadena[inicio]!= ' ')
					inicio--;	
			for(int i=inicio; i<=fin; i++,j++)				
				cadena2[j] = cadena[i];			
			inicio = fin = inicio-1;	
		}		
    }
}
