import java.awt.*;
import java.applet.*;
import java.net.*;

public class DosMil extends Applet{
	public static final int DIM = 4;
	Casilla casillas[][];

    public void init() {
		casillas = new Casilla[DIM][DIM];
		for(int i=0; i<DIM; i++)
			for(int j=0; j<DIM; j++)
				casillas[i][j] = new Casilla(100+(j*Casilla.TAM), 100+(i*Casilla.TAM));
    }
 
    
    public void paint(Graphics g){
    	
		for(int i=0; i<DIM; i++)
			for(int j=0; j<DIM; j++)
				casillas[i][j].dibujar(g, this);
    }

	

}