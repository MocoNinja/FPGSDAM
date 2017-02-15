//Sustituir subcadena1 por subcadena2
package mio_clase;
public class Setentaycuatro {

   public static void main(String[] arcccccc) {
    	char cadena2[] = new char[150];
    	char cadena[] = {'e','n',' ','u','n',' ','l','u','g','a','r',' ','e','n',' ','L','a',' ','M','a','n','c','h','a'};	
    	char subcadena[] = {'e','n', ' '};
    	char subcadena2[] = {'X','X','X','X','X'};
    	subacadenaensubcadena(cadena, cadena2,subcadena,subcadena2);
     //	System.out.print(cadena2);
     }
    
     public static void subacadenaensubcadena(char[] cadena, char cadena2[],char[] subcadena, char[]subcadena2) {
		
		int j=0;
		int i=0;
		int x, y;
		while(i<cadena.length){
			if(cadena[i]!= subcadena[0]){
				cadena2[j] = cadena[i];
				j++;
			}else{
				x = i+1;//para seguir por cadena
				y = 1;//Para seguir por subcadena
				while((y < subcadena.length) && (subcadena[y] == cadena[x])){
					x++;
					y++;
				}
				if(y == subcadena.length)
				//	System.out.println("Encontrado en la posición " + i);
					cadena2[j]=subcadena[y];
					j++;
			}
			i++;
		}
	//	System.out.print(cadena2);
			
    }
}