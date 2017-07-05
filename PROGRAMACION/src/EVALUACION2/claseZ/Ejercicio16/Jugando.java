package EVALUACION2.claseZ.Ejercicio16;
import java.awt.Graphics;
import java.awt.Event;
import java.awt.Image;
import java.awt.Color;
import java.applet.*;
import java.util.List;
import java.util.ArrayList;

public class Jugando extends Applet implements Runnable{
	List<Pelota> pelotas;
	Thread animacion;
	Image imagen;
	Graphics noseve;
    public void init() {
    	pelotas = new ArrayList<Pelota>();
    	pelotas.add(new Pelota(60, 100, 50));
    	imagen = createImage(300, 300);
    	noseve = imagen.getGraphics();
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
    	g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){
    	paint(g);
    }
    
    public void run(){
    	while(true){
			for(int i=0; i<pelotas.size(); i++)
    			pelotas.get(i).actualizar();
			repaint();
    		try{
    			Thread.sleep(10);
    		}catch(InterruptedException e){};
    	}
    }
    
    public boolean mouseDown(Event ev, int x, int y){
    	boolean anadir = true;
    	for(int i=0; i<pelotas.size(); i++){
    		if(pelotas.get(i).contains(x, y)){
    			pelotas.remove(i);
    			anadir = false;
    			break;
    		}
    	}
    	if(anadir)
    		pelotas.add(new Pelota(x-25, y-25, 50));
 
    	return true;
    }
}