import java.awt.*;
import java.applet.*;
import java.net.*;

public class BuscaMinas extends Applet{
	public static final int DIM = 10;
	Casilla casillas[][];
	Image mina;
	Image reverso;

    public void init() {
		reverso = getImage(getCodeBase(), "imagenes/casilla.png");
    	mina = getImage(getCodeBase(), "imagenes/mina.png");
		casillas = new Casilla[DIM][DIM];
		for(int i=0; i<DIM; i++)
			for(int j=0; j<DIM; j++)
				casillas[i][j] = new Casilla(100+(j*Casilla.TAM), 100+(i*Casilla.TAM), reverso);
		
		int aleatorios[] = obtenerAleatorios();
		for(int i=0; i<DIM; i++)
			casillas[aleatorios[i]/DIM][aleatorios[i]%DIM].setMina(mina);
			
		for(int i=0; i<DIM; i++)
			for(int j=0; j<DIM; j++)
				casillas[i][j].setAlrededor(cuentaMinas(i, j));	
    }
 
    
    public void paint(Graphics g){
    	
		for(int i=0; i<DIM; i++)
			for(int j=0; j<DIM; j++)
				casillas[i][j].dibujar(g, this);
    }

	
	public boolean mouseDown(Event ev, int x, int y){
		for(int i=0; i<DIM; i++)
			for(int j=0; j<DIM; j++)
				if(casillas[i][j].contains(x, y)){
					casillas[i][j].destapar();
					repaint();
				}
		return true;
	}
	
	public int[] obtenerAleatorios(){
		int resultados[] = new int[DIM];
		int vector[] = new int[DIM*DIM];
		for(int i=0; i<DIM*DIM; i++)
			vector[i] = i;
			
		for(int i=0; i<DIM; i++){
			int aleatorio = (int)(Math.random() * ((DIM*DIM)-i));
			resultados[i] = vector[aleatorio];
			vector[aleatorio] = vector[(DIM*DIM)-i-1];
		}
		
		return resultados;
	}
	
	public int cuentaMinas(int fila, int columna){
		if (casillas[fila][columna].getMina()!=null)
			return -1;
		else{
			int contador = 0;
			int inicioX = (fila==0)?0:fila-1;
			int finX = (fila==DIM-1)?DIM-1:fila+1;
			int inicioY = (columna==0)?0:columna-1;
			int finY = (columna==DIM-1)?DIM-1:columna+1;
			for(int i=inicioX; i<=finX; i++)
				for(int j=inicioY; j<=finY; j++)
					if(!((i==fila)&&(j==columna)))
						if(casillas[i][j].getMina() != null) contador++;
			return contador;
		}
	}
	
}