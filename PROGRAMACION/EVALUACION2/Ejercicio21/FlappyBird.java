package Ejercicio21;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

import Ejercicio18.Columna;
import Ejercicio18.Pelota;

public class FlappyBird extends Applet implements Runnable{
	
	final int WIDTH = 600, HEIGHT = 600;
	Thread juego;
	Personaje pajaro;
	Graphics ninja;
	Image imagen;
	static boolean click = false;
	ColumnaAgustin columna;
	
	public void init()
	{
		setBackground(Color.black);
		imagen = this.createImage(HEIGHT, WIDTH);
		ninja = imagen.getGraphics();
		pajaro = new Personaje();
		columna = new ColumnaAgustin();
	}
	
	public void start()
	{
		juego = new Thread(this);
		juego.start();
	}
	
	public void run() 
	{
		while(true){
			if (pajaro.muerto)
				System.exit(0);
			pajaro.mueve(click, columna);
			try{
				Thread.sleep(45);
				repaint();
			}
			catch (InterruptedException e){
				e.printStackTrace();
			};
		}
	}
	
	public void paint (Graphics gg)
	{
		imagen = this.createImage(HEIGHT, WIDTH);
		ninja = imagen.getGraphics();
		pajaro.pinta(ninja);
		columna.
		gg.drawImage(imagen, 0, 0, this);
	}
	public boolean mouseDown(Event ev, int x, int y)
	{
			click = true;
		
	return false;
	}
}