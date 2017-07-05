package EVALUACION2.claseZ.Ejercicio17;
import java.awt.Graphics;
import java.awt.Event;
import java.awt.Image;
import java.awt.Color;
import java.applet.*;
import java.util.List;
import java.util.ArrayList;

public class Jugando extends Applet implements Runnable{
	public static final int NUMPELOTAS = 1000;
	List<Pelota> pelotas;
	java.awt.Rectangle rectangulo;
	Thread animacion;
	Image imagen;
	Graphics noseve;
    public void init() {
    	pelotas = new ArrayList<Pelota>();
    	for(int i=0; i<NUMPELOTAS; i++)
    		pelotas.add(new Pelota((int)(Math.random() * 250), (int)(Math.random() * 250), 10));
    	imagen = createImage(300, 300);
    	noseve = imagen.getGraphics();
    	rectangulo = new java.awt.Rectangle(75, 125, 150, 50);
    }
    
    public void start(){
    	animacion = new Thread(this);
    	animacion.start(); //llama al método run
    }
    
    public void paint(Graphics g){
    	noseve.setColor(Color.black);
    	noseve.fillRect(0, 0, 300, 300);
    	for(int i=0; i<pelotas.size(); i++)
    		pelotas.get(i).dibujar(noseve);
    	//noseve.setColor(Color.yellow);
    	//noseve.fillRect(rectangulo.x, rectangulo.y, rectangulo.width, rectangulo.height);
    	g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){
    	paint(g);
    }
    
    public void run(){
    	while(true){
			for(int i=0; i<pelotas.size(); i++){
    			pelotas.get(i).actualizar();
    			if(pelotas.get(i).intersects(rectangulo))
    				pelotas.remove(i);
			}
			repaint();
    		try{
    			Thread.sleep(10);
    		}catch(InterruptedException e){};
    	}
    }
    
}