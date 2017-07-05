package EVALUACION2.claseZ.Ejercicio14;
import java.awt.*;
import java.applet.*;

public class Mondrian extends Applet implements Runnable{
	public static final int NUMRECT = 9;
	Thread animacion;
	Image imagen;
	Graphics noseve;
	int posicionesX[] = {0, 250, 80, 80, 100, 80, 200, 0, 200};
	int posicionesY[] = {0, 0, 110, 200, 10, 100, 100, 110, 55};
	int anchuras[] = {90, 40, 100, 220, 90, 110, 45, 70, 60};
	int alturas[] = {90, 190, 20, 90, 80, 90, 45, 200, 135};
	Color colores[] = {Color.yellow, Color.yellow, Color.yellow, Color.blue, Color.blue, Color.lightGray, Color.red, Color.red, Color.magenta};
	RectanguloHorario rhs[];
	RectanguloAntiHora rhs2[];
	public void init(){
		imagen = this.createImage(300, 300);
		noseve = imagen.getGraphics();
		rhs = new RectanguloHorario[NUMRECT-4];
		rhs2 = new RectanguloAntiHora[NUMRECT-5];
		for(int i=0; i<NUMRECT-4; i++)
			rhs[i] = new RectanguloHorario(posicionesX[i], posicionesY[i], anchuras[i], alturas[i], colores[i]);
		for(int i=0; i<NUMRECT-5; i++)
			rhs2[i] = new RectanguloAntiHora(posicionesX[i+4], posicionesY[i+4], anchuras[i+4], alturas[i+4], colores[i+4]);

	}
	
	public void start(){
		animacion = new Thread(this);
		animacion.start();
	}

   	public void paint(Graphics g){
   		noseve.setColor(Color.black);
   		noseve.fillRect(0, 0, 300, 300);
		for(int i=0; i<NUMRECT-4; i++)
			rhs[i].dibujar(noseve);
		for(int i=0; i<NUMRECT-5; i++)
			rhs2[i].dibujar(noseve);
   		g.drawImage(imagen, 0, 0, this);
   	}
   	
   	public void update(Graphics g){
   		paint(g);
   	}
    
    public void run(){
    	while(true){
			for(int i=0; i<NUMRECT-4; i++)
				rhs[i].actualizar();
			for(int i=0; i<NUMRECT-5; i++)
				rhs2[i].actualizar();
			repaint();
    		try{
    			Thread.sleep(50);
    		}catch(InterruptedException e){};
    	}
    }
    
}