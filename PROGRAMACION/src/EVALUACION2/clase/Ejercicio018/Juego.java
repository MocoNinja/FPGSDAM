package EVALUACION2.clase.Ejercicio018;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;


public class Juego extends Applet implements Runnable
{
	
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 1000;
	
	Thread ani;
	Graphics ninja;
	Image imagen;

	List<Pelota> listica = new ArrayList<Pelota>();
	Pelota bola;
	int pelotas = 5645;
	Random rand = new Random();	
	Rectangle caja = new Rectangle(300, 600, 100, 200);


	
	public void init()
	{
		setBackground(Color.black);
		imagen = this.createImage(HEIGHT, WIDTH);
		ninja = imagen.getGraphics();
		cargar(pelotas);
		
	}
	public void start()
	{
		ani = new Thread(this);
		ani.start();
	}
	
	@Override
	public void run() 
	{
		while(true){
			for (int i = 0; i < listica.size(); i++)
			{
				listica.get(i).mueve();
			}
			for (int i = 0; i < listica.size(); i++)
			{
				if (listica.get(i).intersects(caja))
				{
					listica.remove(i);
				}
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
	
	public void cargar (int pelotas)
	{
		for (int i = 0; i <= pelotas; i++)
		{
			listica.add(new Pelota());
		}
		
	}
	
	public void paint (Graphics gg){
		imagen = this.createImage(HEIGHT, WIDTH);
		ninja = imagen.getGraphics();
		for (int i = 0; i < listica.size(); i++)
		{
			listica.get(i).pinta(ninja);
		}
		ninja.setColor(Color.RED);
		ninja.fillRect(300, 600, 300, 200);
		gg.drawImage(imagen, 0, 0, this);
		}
}
