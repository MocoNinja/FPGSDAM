package EVALUACION2.clase.Ejercicio021_CASA;

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
	final int PAREDES_MAX = 3;
	int puntuacion = 0;
	String puntos;
	boolean suma = true;
	String nivel = "";
	
	public void init()
	{
		setBackground(Color.BLACK);
		pajaro = new Pj();
		paredes = new ArrayList<Col>();
		for (int i = 0; i < PAREDES_MAX; i++)
		{
			paredes.add(new Col(i));
		}
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
		puntos = "";
		puntos += nivel + " "+ puntuacion;
		g.drawString(puntos, WIDTH-20, HEIGHT - 20);
	}
	
	public void paredes()
	{
		if (paredes.get(0).getX() < pajaro.x && suma)
		{
			puntuacion++;
			suma = false;
		}
		
		if (paredes.get(0).getX() <= 5)
		{
			paredes.remove(paredes.get(0));
			suma = true;
			paredes.add(new Col(paredes.size()));
		}
		
		if (paredes.size() <= PAREDES_MAX)
		{
			paredes.add(new Col(paredes.size()));
		}
		if (puntuacion > PAREDES_MAX)
		{
			Col.vX++;
			nivel += "·";
			puntuacion = 0;
		}
	}
	
	public boolean mouseDown(Event ev, int x, int y)
	{
		// System.out.println("Pulsado");
		pajaro.y -= 45;
		return true;
	}
}
