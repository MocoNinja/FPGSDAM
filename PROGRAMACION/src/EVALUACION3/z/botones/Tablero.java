import java.awt.*;
import java.applet.*;

public class Tablero extends Applet{
	public static final int TAM = 5; 
	Image imagenes[][];
	Lugar lugares[][];
	
    public void init() {
    	imagenes = new Image[TAM][TAM];
    	for(int i=0; i<TAM; i++)
    		for(int j=0; j<TAM; j++)
    			if(!((i==TAM-1) && (j==TAM-1)))
    				imagenes[i][j] = getImage(getCodeBase(), "botones/" + ((i*TAM)+j+1) + ".gif");
    	lugares = new Lugar[TAM][TAM];
    	for(int i=0; i<TAM; i++)
    		for(int j=0; j<TAM; j++)
    			lugares[i][j] = new Lugar(imagenes[i][j], (i*TAM)+j);
    }
    
    public void paint(Graphics g){
    	for(int i=0; i<TAM; i++)
    		for(int j=0; j<TAM; j++)
				lugares[i][j].dibujar(g, this, j, i);
    }
}
}