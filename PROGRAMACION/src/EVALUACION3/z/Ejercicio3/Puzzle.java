import java.awt.*;
import java.applet.*;

public class Puzzle extends Applet{
	public static final int PIEZAS = 25;
	public static final int FILAS = 5;
	Image imagenes[];
	Image imagen;
	Image mapaMundi;
	Graphics noseve;
	Pieza piezas[];
	Pieza activa;
	Rectangle huecos[][];
    public void init() {
    	imagen = createImage(700, 500);
    	noseve = imagen.getGraphics();
    	mapaMundi = getImage(getCodeBase(), "directorioImagenes/mapamundi3.png");
    	imagenes = new Image[PIEZAS];
    	piezas = new Pieza[PIEZAS];
    	for(int i=0; i<PIEZAS; i++){
    			imagenes[i] = getImage(getCodeBase(), "directorioImagenes/" + (i+1) + ".png");
    			piezas[i] = new Pieza(imagenes[i], i);
    	}
    	huecos = new Rectangle[FILAS][FILAS];
    	for(int i=0; i<FILAS; i++)
    		for(int j=0; j<FILAS; j++)
    			huecos[i][j] = new Rectangle((j*Pieza.DIMENSION)+50, (i*Pieza.DIMENSION)+100, Pieza.DIMENSION, Pieza.DIMENSION);
    }
    
    public void paint(Graphics g){
    	noseve.setColor(Color.black);
    	noseve.fillRect(0, 0, 700, 500);
		noseve.drawImage(mapaMundi, 50, 100, this);
    	for(int i=0; i<PIEZAS; i++)
    		piezas[i].dibujar(noseve, this);
    	/*noseve.setColor(Color.white);
    	for(int i=0; i<FILAS; i++)
    		for(int j=0; j<FILAS; j++)
    			noseve.drawRect(huecos[i][j].x, huecos[i][j].y, huecos[i][j].width, huecos[i][j].height);
    	*/
    	g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){
    	paint(g);
    }
    
    public boolean mouseDown(Event ev, int x, int y){
		for(int i=0; i<PIEZAS; i++)
			if((piezas[i].contains(x, y)) && (!piezas[i].getColocado()))
				activa = piezas[i];
    	return true;
    }
    
    public boolean mouseUp(Event ev, int x, int y){
    	if(activa!=null){
    		for(int i=0; i<FILAS; i++){
    			for(int j=0; j<FILAS; j++){
    				if(huecos[i][j].intersects(activa)){
    					if(activa.posicion == (i*FILAS)+j){
							activa.moverJusto(huecos[i][j].x, huecos[i][j].y);
							activa.setColocado(true);
							repaint();
    					}
    				}
    			}
    		}
    	}    			
		activa = null;
    	return true;
    }
    
    public boolean mouseDrag(Event ev, int x, int y){
		if(activa != null){
			activa.mover(x, y);
			repaint();
		}
    	return true;
    }
}