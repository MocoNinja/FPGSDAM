package EVALUACION2.rehechoRepaso.flappy;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class AppletApp extends Applet implements Runnable
{
	final static int WIDTH = 600, HEIGHT = 600;
	final int MAX_COLS = 5;
	Thread app;
	Pajaro bird;
	Graphics ninja;
	Image afoto;
	public boolean gameOver = false;
	List<Columna> palos;
	
	public void init()
	{
		bird = new Pajaro();
		palos = new ArrayList<Columna>();
		for (int i = 0; i < MAX_COLS; i++) palos.add(new Columna(WIDTH - palos.size() * Columna.ESPACIO));
	}
	
	public void start()
	{
		app = new Thread(this);
		app.start();
	}
	
	public void run()
	{
		while(true)
		{
			gameOver = !bird.isAlive();
			if (gameOver)
			{
				repaint();
				app.stop();
			}
			else try
			{
				mueves();
				Thread.sleep(65);
				repaint();
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
	
	public void mueves()
	{
		bird.mueve();
		for (int i = 0; i < palos.size(); i++)
		{
			palos.get(i).mueve(bird);
			if (palos.get(i).x <= 0)
			{
				palos.add(new Columna(palos.get(palos.size() - 1).x + Columna.ESPACIO));
				palos.remove(i);
			}
		}
	}
	
	public void pintajes(Graphics aux)
	{
		setBackground(Color.BLACK);
		afoto = createImage(WIDTH, HEIGHT);
		ninja = afoto.getGraphics();
		if (gameOver)
		{
			ninja.setColor(Color.RED);
			ninja.drawString("GAME OVER", WIDTH / 2, HEIGHT / 2);
		} else
		{
			bird.pinta(ninja);
			for (int i = 0; i < palos.size(); i++) palos.get(i).pinta(ninja);
		}
		
		aux.drawImage(afoto, 0, 0, this);
	}
	
	public void paint(Graphics g)
	{
		pintajes(g);
	}

	public boolean mouseDown(Event ev, int x, int y)
	{
		bird.y -= 10 * bird.ySpeed;
		repaint();
	return true;
	}
}
