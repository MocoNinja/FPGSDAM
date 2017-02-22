package FlappyBird;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class App extends Applet implements Runnable{
	
	Thread ui;
	Graphics ninja;
	
	Pj pajaro;
	Col pared;
	List<Col> paredes;
	
	final static int WIDTH = 600, HEIGHT = 600;
	final int PAREDES_MAX = 2;
	
	public void init()
	{
		setBackground(Color.BLACK);
		pajaro = new Pj();
		paredes = new ArrayList<Col>();
		paredes.add(new Col());
	}
	
	public void start()
	{
		ui = new Thread(this);
		ui.start();
	}
	
	public void run()
	{
		while (true)
		{
			if (!pajaro.vivo)
			{
				setBackground(Color.RED);
				repaint();
				ui.stop();
			}
			else
			{
				pajaro.mueve();
				paredes();
				for (int i = 0; i < paredes.size(); i++)
				{
					paredes.get(i).mueve(pajaro);
				}
			}
			try {
				Thread.sleep(15);
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void paint(Graphics g)
	{
		pajaro.dibujar(g);
		for (int i = 0; i < paredes.size(); i++)
		{
			paredes.get(i).dibujar(g);
		}
	}
	
	public void paredes()
	{
		if (paredes.size() < PAREDES_MAX && paredes.get(0).getX() <= WIDTH/2)
		{
			paredes.add(new Col());
		}
		
		if (paredes.get(0).getX() <= -10)
		{
			paredes.remove(paredes.get(0));
			paredes.add(new Col());
		}
	}
	
	public boolean mouseDown(Event ev, int x, int y)
	{
		// System.out.println("Pulsado");
		pajaro.y -= 30;
		return true;
	}
}
