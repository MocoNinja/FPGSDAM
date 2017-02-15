package mio_clase;
//Eliminar subcadena multiple de cadena

public class Setentayseis {

	public static void main(String[] arcccccc) {
	char cadena[] = {'e','n',' ','u','n',' ','l','u','g','a','r',' ','e','n',' ','L','a',' ','M','a','n','c','h','a',' '};	
	char subcadena[] = {'e','n',' '};
	int longitud=cadena.length;
	
	/*for (int y = 0; y < subcadena.length; y++) {
		desplazarIzq(cadena, longitud, 1);
		longitud--;
	}*/
	int i=0;
	int x, n;
	while(i<cadena.length){
		if(cadena[i]!= subcadena[0]){
			
			i++;
		}else{
		
			x = i+1;//para seguir por cadena
			n = 1;//Para seguir por subcadena
			while((n < subcadena.length) && (subcadena[n] == cadena[x])){
				x++;
				n++;
			}
			if(n == subcadena.length){
				desplazamientosIzq(cadena, longitud, x-(subcadena.length-1), subcadena.length);
				}
			i = i+subcadena.length -1;	
			}
		
		i++;
		
	}
	
	
	System.out.print(cadena);
	}

	public static void desplazarIzq(char[] cadena, int largura, int inicio) {
		
		for(int x=inicio; x<largura;x++)
			cadena[x-1]=cadena[x];
		cadena[largura-1] = ' ';
		
	}
	
	public static void desplazamientosIzq(char cadena[], int largura, int inicio, int num_despl) {
		for (int y = 0; y < num_despl; y++) {
			for (int x = inicio; x < largura; x++) {
				cadena[x-1]=cadena[x];
			cadena[largura-1]= ' ';
				
			}
			
		}
		
	}

}