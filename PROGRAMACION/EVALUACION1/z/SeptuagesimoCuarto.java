package z;
public class SeptuagesimoCuarto {

	public static void main(String arg[]){
		char cadena[] = {'e', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'}; 
		char subcad[] = {'e', 'n', ' '} ;
		int longitud = cadena.length;
		int i = 0;
		int x, y;
		while(i<longitud-subcad.length){
			if(cadena[i] == subcad[0]){
				x = i+1;//para seguir por cadena
				y = 1;//para seguir por subcad1
				while((y<subcad.length) && (subcad[y] == cadena[x])){
					x++;
					y++;
				}
				if(y == subcad.length){
					longitud = desplazamientosIzq(cadena, longitud, i, subcad.length);
				}
			}
			i++;
		}
		
		/*for(int y=0; y<subcad.length; y++){
			desplazarIzq(cadena, longitud, 1);
			longitud--;
		}
		
		System.out.print(cadena);
		System.out.println(" longitud vale = " + longitud);
		
		longitud = desplazamientosIzq(cadena, longitud, 1, subcad.length);
			
		System.out.print(cadena);
		System.out.println(" longitud vale = " + longitud);*/
		
		System.out.print(cadena);
		
    }
    
    public static void desplazarIzq(char cadena[], int largura, int inicio){
		for(int x=inicio+1; x<largura; x++)
			cadena[x-1] = cadena[x];
		cadena[largura-1] = ' ';
    }
    
    public static int desplazamientosIzq(char cadena[], int largura, int inicio, int num_despl){
		for(int y=0; y<num_despl; y++){
    		for(int x=inicio+1; x<largura; x++)
				cadena[x-1] = cadena[x];
			cadena[largura-1] = ' ';
			largura--;
		}
		return largura;
    }
    
}