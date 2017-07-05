import java.awt.*;
import java.applet.*;
import java.net.*;

public class Solitario extends Applet{
	public static final int NUM_PALOS = 4;
	public static final int NUM_CARTAS = 52;
	public static final int CPP = 13;
	String nombres[] = {"_of_clubs.png", "_of_diamonds.png", "_of_hearts.png", "_of_spades.png"};
	Image imagenes[];
	Image imgReverso;
	Rectangle reverso;
	Baraja baraja;
	MazoSecundario mSecundario;
	Carta activa;
	Image imagen;
	Graphics noseve;
	MazoPalo mPalos[];
	MazoJuego mJuegos[];
	
    public void init() {
    	imagen = createImage(900, 700);
    	noseve = imagen.getGraphics();
		imagenes = new Image[NUM_CARTAS];
		for(int i=0; i<NUM_PALOS; i++)
			for(int j=0; j<CPP; j++)
				imagenes[(i*CPP)+j] = getImage(getCodeBase(), "Cartas/" + (j+1) + nombres[i]);
		imgReverso = getImage(getCodeBase(), "Cartas/reverso.png");
		reverso = new Rectangle(20, 20, 70, 120);
		baraja = new Baraja(imagenes);
		baraja.barajar();
		mSecundario = new MazoSecundario();
		mPalos = new MazoPalo[NUM_PALOS];
		for(int i=0; i<NUM_PALOS; i++)
			mPalos[i] = new MazoPalo(400 + (i*100));
		mJuegos = new MazoJuego[7];
		for(int i=0; i<7; i++)
			mJuegos[i] = new MazoJuego(100 + (i*100));
	}
    
    public void paint(Graphics g){
    	noseve.setColor(Color.green);
    	noseve.fillRect(0, 0, 900, 700);
		noseve.drawImage(imgReverso, 20, 20, Carta.ANCHURA, Carta.ALTURA, this);
		for(int i=0; i<NUM_PALOS; i++)
			mPalos[i].mostrar(noseve, this);
		for(int i=0; i<7; i++)
			mJuegos[i].mostrar(noseve, this);
			
		mSecundario.mostrar(noseve, this);
		//if(activa!=null) activa.dibujar(noseve, this);

		g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){
    	paint(g);
    }
    
    public boolean mouseDown(Event ev, int x, int y){
    	if(reverso.contains(x, y)){
    		mSecundario.anadir(baraja.sacar());
    		mSecundario.recolocar();
    		repaint();
    	}
    	if(mSecundario.extraer().contains(x, y)){
    		activa = mSecundario.extraer();    		
    	}    	
    	return true;
    }
    
    public boolean mouseDrag(Event ev, int x, int y){
    	if(activa!=null){
    		activa.setPosx(x - (Carta.ANCHURA/2));
    		activa.setPosy(y - (Carta.ALTURA/2));
    		repaint();
    	}
    	
    	return true;
    }

    public boolean mouseUp(Event ev, int x, int y){
    	if(activa!=null){
    		boolean encontrado = false;
    		for(int i=0; i<NUM_PALOS; i++)
    			if(mPalos[i].intersects(activa)){
    				if(mPalos[i].anadir(mSecundario.extraer())){
     					mSecundario.eliminar();
    					encontrado = true;
    					break;
    				}	
    			}
    		
    		for(int i=0; i<7; i++)
    			if(mJuegos[i].intersects(activa)){
    				if(mJuegos[i].anadir(mSecundario.extraer())){
     					mSecundario.eliminar();
    					encontrado = true;
    					break;    					
    				}
    			}
    					
    		if(!encontrado)
    			mSecundario.recolocar();
    		activa = null;
    		repaint();
    	}
		
    	return true;
    }
}