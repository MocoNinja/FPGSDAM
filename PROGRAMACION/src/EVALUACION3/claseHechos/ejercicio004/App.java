package EVALUACION3.claseHechos.ejercicio004;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import EVALUACION3.claseHechos.ejercicio002.Hueco;

public class App extends Applet implements Runnable
{
	Image buffer;
	Thread app;
	Graphics aux;
	private final int WIDTH = 1500, HEIGTH = 800;
	Arquero pj;
	Image[] sprites;
	List<Globo> globos;
//	List<FlechaPunto> flechas;
	List<FlechaRectangle> flechas;
	final private int MAX_GLOBOS = 5;
	final private int MAX_FLECHAS = 30;
	private final int ARQUERO = 0, FLECHA = 1, GLOBO = 2;
	int contador; // Temporal
	
	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(50);
				repaint();
				if(globos.size() == 0) app.stop();
				System.out.println("Globos: " + globos.size());
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void start()
	{
		app = new Thread(this);
		app.start();
	}
	
	public void init()
	{
		sprites = new Image[3];
//		flechas = new ArrayList<FlechaPunto>();
		flechas = new ArrayList<FlechaRectangle>();
		globos = new ArrayList<Globo>();
		sprites[0] = getImage(getDocumentBase(), "EVALUACION3/clase/ejercicio004/sprites/arquero.gif");
		sprites[1] = getImage(getDocumentBase(), "EVALUACION3/clase/ejercicio004/sprites/flecha.gif");
		sprites[2] = getImage(getDocumentBase(), "EVALUACION3/clase/ejercicio004/sprites/globo.gif");
		buffer = createImage(WIDTH, HEIGTH);
		aux = buffer.getGraphics();
		pj = new Arquero(25, HEIGHT / 2, sprites[ARQUERO]);
		for (int i = 0; i <= MAX_GLOBOS; i++)
			globos.add(new Globo(sprites[GLOBO]));
		contador = 0;
	}
	
	public void paint(Graphics g)
	{
		aux = buffer.getGraphics();
		aux.fillRect(0, 0, WIDTH, HEIGTH);
		pj.pinta(aux, this);
		if (globos.size() == 0)
		{
			aux.setColor(Color.RED);
			aux.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
			aux.drawString("Ganaste", 250, 250);
		}
		for (int i = 0; i < flechas.size(); i++) flechas.get(i).pinta(aux, this);
		for (int i = 0; i < globos.size(); i++) globos.get(i).pinta(aux, this);
//		puntoMira(pj.getX(), pj.getY(), aux);
		g.drawImage(buffer, 0, 0, this);
	}
	
	public void update(Graphics g)
	{
		for (int i = 0; i < flechas.size(); i++)
		{
//			flechas.get(i).mueveLinea();
			flechas.get(i).mueveArco(globos);
			if (flechas.get(i).x > WIDTH) flechas.remove(i);
		}
		
		for (int i = 0; i < globos.size(); i++)
		{
			// globos.get(i).muevePuntos(flechas);
			globos.get(i).mueveRects(flechas);
			if (globos.get(i).y < - 10 || !globos.get(i).isAlive())
			{
			globos.remove(i);
			}
		}
		
		paint(g);
	}

	public void puntoMira(int x, int y, Graphics g)
	{
		g.setColor(Color.RED);
		final int espacio = 55;
		for (int i = 0; i <= 35; i++) g.fillOval(x + pj.getWidth() + espacio * i, y, 5, 5);
	}
	
	public boolean mouseMove(Event ev, int x, int y)
	{
		if (y > 0 || y < HEIGHT - pj.getHeight()) pj.mueve(y);
		x = pj.getX();
	return true;
	}
	
	public boolean mouseDown(Event ev, int x, int y)
	{
		if (flechas.size() < MAX_FLECHAS)
		{
//			flechas.add(new FlechaPunto(pj.getX(), pj.getY() + pj.getHeight() / 2, sprites[FLECHA]));
			flechas.add(new FlechaRectangle(pj.getX(), pj.getY() + pj.getHeight() / 2, sprites[FLECHA]));
		}
		
	return true;
	}
	
}
