package EVALUACION2.examen;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class AppletApp extends Applet implements Runnable
{
	final static int WIDTH = 600, HEIGHT = 600;
	Thread app;
	Graphics ninja;
	Image aux;
	private final int MAX_BOLAS = 20;
	private boolean gameOver = false;
	List<Bola> bolas;
	Rectangulo pj;
	
	public void init()
	{
		bolas = new ArrayList<Bola>();
		for (int i = 0; i < MAX_BOLAS; i++) bolas.add(new Bola());
		pj = new Rectangulo();
	}
	
	public void start()
	{
		app = new Thread(this);
		app.start();
	}
	
	public void paint(Graphics fake)
	{
		setBackground(Color.BLACK);
		aux = createImage(WIDTH, HEIGHT);
		ninja = aux.getGraphics();
		if (!gameOver) pintarrujeos(ninja);
		else
		{
			ninja.setColor(Color.RED);
			ninja.drawString("You DIED", WIDTH / 2, HEIGHT / 2);
		}
		fake.drawImage(aux, 0, 0, this);
	}
	
	public void run()
	{
		while(true)
		{
			gameOver = !pj.isAlive();
			if (gameOver)
			{
				repaint();
				app.stop();
			}
			else
			{
				mueveBolas();
				try
				{
					Thread.sleep(65);
					repaint();
				} catch (InterruptedException e) {e.printStackTrace();}
			}
		}
	}
	
	public void pintarrujeos(Graphics aux)
	{
		for (int i = 0; i < bolas.size(); i++) bolas.get(i).pinta(aux);
		pj.pinta(aux);
	}

	public void mueveBolas()
	{
		for (int i = 0; i < bolas.size(); i++)
		{
			 bolas.get(i).mueve(pj);
			 if (!bolas.get(i).isAlive())
			 {
				 bolas.remove(i);
				 bolas.add(new Bola());
			 }
		}
		// System.out.println("Que presa esta vivo es " + pj.isAlive());
	}

	public boolean mouseMove(Event ev, int x, int y)
	{
		if (x >= 0 && x <= WIDTH && !gameOver) pj.x = x;
		if (y >= 0 && y <= HEIGHT - pj.width && !gameOver) pj.y = y;
		repaint();
	return true;
	}
}
