package claseViejo.Ejercicio015;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/*
* Java tiene una clase llamada Rectangulo, que tiene metodos para ver colisiones y tal.
* Es Rectangle (x, y, ancho, alto)
*/
public class MondrianBetter extends Applet implements Runnable{

	Thread ani;
	Graphics ninja;
	Image imagen;
	
	final int HEIGHT = 300, WIDTH = 300; // Del Applet
	
	final int numeroRectangulos = 9;
	
	int[] posicionesX = {0, 250, 80, 80, 100, 80, 200, 0, 200};
	int[] posicionesY = {0, 0, 110, 200, 10, 0, 100, 110, 55};
	int[] anchuras = {90, 40, 100, 220, 90, 110, 45, 70, 60};
	int[] alturas = {90, 190, 20, 90, 80, 90, 45, 200, 135};
	
	Color[] colores = {Color.RED, Color.CYAN, Color.GRAY, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.BLUE, Color.BLACK, Color.ORANGE, Color.PINK};
	
	TronchoHorario[] rectangulos = new TronchoHorario[numeroRectangulos];
	
	public void init(){
		
		imagen = this.createImage(HEIGHT, WIDTH);
		ninja = imagen.getGraphics();
		
		for (int i = 0; i < numeroRectangulos; i++)
		{
			rectangulos[i] = new TronchoHorario(posicionesX[i], posicionesY[i], alturas[i], anchuras[i], colores[i]);
		}
	}
	public void start(){
		ani = new Thread(this);
		ani.start();
	}
	
	public void run() {
		while(true){
			for (int i = 0; i < numeroRectangulos; i++)
			{
				rectangulos[i].mueve();
			}
			repaint();
			try{
				Thread.sleep(60);
			}
			catch (InterruptedException e){};
		}
	}
	
	public void paint (Graphics gg){
		for (int i = 0; i < numeroRectangulos; i++)
		{
			rectangulos[i].mostrar(gg);
		}
	}

}
