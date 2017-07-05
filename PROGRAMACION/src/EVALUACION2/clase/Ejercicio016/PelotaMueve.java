package EVALUACION2.clase.Ejercicio016;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;


public class PelotaMueve extends Applet implements Runnable{
	
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	Thread ani;
	Pelota bola = new Pelota();
	Graphics ninja;
	Image imagen;
	int puntos = 0;
	
	public void start(){
		ani = new Thread(this);
		imagen = this.createImage(HEIGHT, WIDTH);
		ninja = imagen.getGraphics();
		ani.start();
		System.out.println("Puntuación: " + puntos);
	}
	
	@Override
	public void run() 
	{
		while(true){
			bola.mueve();
			repaint();
			try{
				Thread.sleep(60);
			}
			catch (InterruptedException e){};
		}
	}
	
	public void paint (Graphics gg){
		setBackground(Color.black);
		bola.pinta(gg);
	}

	public boolean mouseDown(Event ev, int x, int y)
	{
		//System.out.println("Mouse click");
		
		if (bola.contains(x, y))
		{
			bola.dibujando = false;
			puntos += 100;
			System.out.println("Puntuación: " + puntos);
			bola = new Pelota();
		return true;
		}
	return false;
	}
	
}
