package Ejercicio17;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Juego extends Applet implements Runnable{
	
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 1000;
	
	Thread ani;
	Graphics ninja;
	Image imagen;
	int puntos = 0;
	List<Pelota> listica = new ArrayList<Pelota>();
	Pelota bola;
	public int fallos;
	Random rand = new Random();
	
	public void init()
	{
		setBackground(Color.black);
		imagen = this.createImage(HEIGHT, WIDTH);
		ninja = imagen.getGraphics();
		for (int i = 0; i <= 2; i++)
		{
			listica.add(new Pelota());
		}
	}
	public void start(){
		ani = new Thread(this);
		ani.start();
	}
	
	@Override
	public void run() 
	{
		while(true){
		
			for (int i = 0; i < listica.size(); i++){
				listica.get(i).mueve();
			}
			try{
				Thread.sleep(45);
				repaint();
			}
			catch (InterruptedException e){
				e.printStackTrace();
			};
		}
	}
	
	public void paint (Graphics gg){
		imagen = this.createImage(HEIGHT, WIDTH);
		ninja = imagen.getGraphics();
		for (int i = 0; i < listica.size(); i++){
			listica.get(i).pinta(ninja);
		}
		gg.drawImage(imagen, 0, 0, this);
	}

	public boolean mouseDown(Event ev, int x, int y)
	{
		fallos = 0;
		for (int i = 0; i < listica.size(); i++){
			if (listica.get(i).contains(x,y)){
				System.out.println("Muere");
				listica.remove(i);
			return true;
			} else {
				fallos++;
				System.out.println(fallos);
				if (fallos == listica.size()){
					listica.add(new Pelota());
					for (int j = 0; j < listica.size(); j++)
					{
						listica.get(j).addSpeed();
						listica.get(j).rmSize();
					}
					break;
				}
			}
		}
	return false;
	}
	
}
