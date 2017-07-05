package EVALUACION2.claseZ.Ejercicio15;
import java.awt.*;
import java.applet.*;

public class Jugando extends Applet implements Runnable{
	Pelota pelota;
	Thread animacion;
	Image imagen;
	Graphics noseve;
    public void init() {
    	pelota = new Pelota(60, 100, 50, Color.red);
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
    	pelota.dibujar(noseve);
    	g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){
    	paint(g);
    }
    
    public void run(){
    	while(true){
			pelota.actualizar();
			repaint();
    		try{
    			Thread.sleep(10);
    		}catch(InterruptedException e){};
    	}
    }
    
    public boolean mouseDown(Event ev, int x, int y){
    	if(pelota.contains(x, y))
    		pelota.visible = false;
    	return true;
    }
}