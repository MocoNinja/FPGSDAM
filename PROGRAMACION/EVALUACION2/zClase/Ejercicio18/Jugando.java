package zClase.Ejercicio18;
import java.awt.Graphics;
import java.awt.Event;
import java.awt.Image;
import java.awt.Color;
import java.applet.*;
import java.util.List;
import java.util.ArrayList;

public class Jugando extends Applet implements Runnable{
	public static final int FILAS = 5;
	public static final int COLUMNAS = 10;
	public static final int DERECHA = 0;
	public static final int IZQUIERDA = 1;
	Color colores[] = {Color.red, Color.orange, Color.green, Color.yellow, Color.magenta};
	List<Block> pared;
	Pelota pelota;
	Raqueta raqueta;
	Thread animacion;
	Image imagen;
	Graphics noseve;
    public void init() {
    	pared = new ArrayList<Block>();
    	for(int i=0; i<FILAS; i++)
    		for(int j=0; j<COLUMNAS; j++)
    			pared.add(new Block((30*j)+1, (12*i)+10 , 28, 10, colores[i]));
    	pelota = new Pelota();
    	raqueta = new Raqueta();
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
    	for(int i=0; i<pared.size(); i++)
    		pared.get(i).dibujar(noseve);
    	pelota.dibujar(noseve);
    	raqueta.dibujar(noseve);
    	if(pelota.fin){
			noseve.setColor(Color.white);
    		noseve.drawString("Game Over", 120, 140);
    	}
	   	g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){
    	paint(g);
    }
    
    public void run(){
    	while(true){
			pelota.actualizar(pared, raqueta);
			repaint();
    		try{
    			Thread.sleep(20);
    		}catch(InterruptedException e){};
    	}
    }
    
    public boolean keyDown(Event ev, int tecla){
    	if(tecla == 1006)
    		raqueta.actualizar(IZQUIERDA);
    	if(tecla == 1007)
    		raqueta.actualizar(DERECHA);
    	return true;
    }
    
}