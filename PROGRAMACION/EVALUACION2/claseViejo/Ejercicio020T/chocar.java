package claseViejo.Ejercicio020T;
import java.awt.Graphics;
import java.awt.Event;
import java.awt.Image;
import java.awt.Color;
import java.applet.*;
import java.util.List;
import java.util.ArrayList;
public class chocar extends Applet implements Runnable{
	Color colores[] = {Color.red, Color.orange, Color.green, Color.yellow, Color.magenta};
	List<ClaseA> ovalos;
	List<ClaseB> rectangulos;
	int rect = 1;
	Thread animacion;
	Image imagen;
	Graphics noseve;
	int Waleatorio; 
	int Haleatorio;
    public void init() {
    	ovalos = new ArrayList<ClaseA>();
    	for(int i=0; i<100; i++){
    		Waleatorio = (int) (Math.random()*690+1);
			Haleatorio = (int) (Math.random()*690+1);
    		ovalos.add(new ClaseA(Waleatorio, Haleatorio , 10, 10, Color.red));
    	}
    		
    	
    	rectangulos = new ArrayList<ClaseB>();
    	for(int i=0; i<rect; i++)
    		rectangulos.add(new ClaseB(60, 60 , 10, 10, Color.blue));
    	imagen = createImage(700, 700);
    	noseve = imagen.getGraphics();
    	
    }
    
    public void start(){
    	animacion = new Thread(this);
    	animacion.start(); //llama al método run
    }
    
    public void paint(Graphics g){
    	noseve.setColor(Color.black);
    	noseve.fillRect(0, 0, 700, 700);
    	for(int i=0; i<ovalos.size(); i++)
    		ovalos.get(i).dibujar(noseve);
    	for(int i=0; i<rectangulos.size(); i++)
    		rectangulos.get(i).dibujar(noseve);
	   	g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){
    	paint(g);
    }
    
    public void run(){
    	while(true){
    		for(int i=0; i<ovalos.size(); i++){
    			//ovalos.get(i).actualizar(ovalos);
				ovalos.get(i).actualizar(rectangulos, ovalos);
    		}
			
				
			for(int i=0; i<rectangulos.size(); i++){
				rectangulos.get(i).actualizar(rectangulos, ovalos);
				//rectangulos.get(i).actualizar();
			}
				
			repaint();
    		try{
    			Thread.sleep(20);
    		}catch(InterruptedException e){};
    	}
    }
    
    public boolean keypress(Event ev, int tecla){
    	System.out.print("llega");
    	return true;
    }
 
}