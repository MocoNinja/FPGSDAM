package EVALUACION2.claseZ.Ejercicio20;
import java.awt.Graphics;
import java.awt.Event;
import java.awt.Image;
import java.awt.Color;
import java.applet.*;
import java.util.List;
import java.util.ArrayList;

public class Jugando extends Applet implements Runnable{
	public static final int DISTANCIA = 100;
	public static final int POSINICIAL = 250;
	Pajaro pajaro;
	List<Columna> columnas;
	public static int contador = 0;
	Thread animacion;
	Image imagen;
	Graphics noseve;
	boolean fin = false;
    public void init() {
    	pajaro = new Pajaro();
    	columnas = new ArrayList<Columna>();
    	for(int i=0; i<3; i++)
    		columnas.add(new Columna(POSINICIAL+((DISTANCIA+Columna.ANCHURA)*i)));
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
     	pajaro.dibujar(noseve);
     	for(int i=0; i<columnas.size(); i++)
     		columnas.get(i).dibujar(noseve);
     	noseve.setColor(Color.white);
     	noseve.drawString("Pasadas : " + contador, 100, 30);
     	if(fin){
			noseve.setColor(Color.red)     		;
     		noseve.drawString("Game Over", 100, 120);
     	}
	   	g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){
    	paint(g);
    }
    
    public void run(){
    	while(true){
			pajaro.actualizar();
			for(int i=0; i<columnas.size(); i++)
				columnas.get(i).actualizar();
			if((columnas.get(0).r1.intersects(pajaro)) || (columnas.get(0).r2.intersects(pajaro))){
				fin = true;
				repaint();
				animacion.stop(); 
			}
			repaint();
    		try{
    			Thread.sleep(50);
    		}catch(InterruptedException e){};
    	}
    }
    
    public boolean mouseDown(Event ev, int x, int y){
		pajaro.y -= 15;
    	return true;
    }
    
}