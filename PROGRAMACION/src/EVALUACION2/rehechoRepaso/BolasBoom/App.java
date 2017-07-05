package EVALUACION2.rehechoRepaso.BolasBoom;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class App extends Applet implements Runnable
{
	final static int WIDTH = 600, HEIGHT = 600;
	final int MAX_BOLAS = 100;
	private final int CUADRAU = 0;
	private final int BOLA = 1;
	int FIGURA = CUADRAU;
	Bola bola = new Bola();
	Thread app;
	Graphics ninja;
	Image aux;
	List <Bola> bolas;
	List <Cuadrao> cuadraus;
	
	public void start()
	{
		bolas = new ArrayList<Bola>();
		cuadraus = new ArrayList<Cuadrao>();
		for (int i = 0; i < MAX_BOLAS; i++) bolas.add(new Bola());
		cuadraus.add(new Cuadrao());
		app = new Thread(this);
		app.start();
	}
	
	public void paint (Graphics fake)
	{
		setBackground(Color.BLACK);
		aux = createImage(WIDTH, HEIGHT);
		ninja = aux.getGraphics();
		pintarrujeos(ninja);
		fake.drawImage(aux, 0, 0, this);
	}
	
	public void pintarrujeos(Graphics aux)
	{
		for (int i = 0; i < bolas.size(); i++) bolas.get(i).pinta(aux);
		for (int i = 0; i < cuadraus.size(); i++) cuadraus.get(i).pinta(aux);
	}
	
	public void run()
	{
		while(true)
		{
			try {
				elMueve();
				collisionator();
				Thread.sleep(65);
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void elMueve()
	{
		for (int i = 0; i < bolas.size(); i++) bolas.get(i).mueve();
		for (int i = 0; i < cuadraus.size(); i++) cuadraus.get(i).mueve();
	}
	
	public void collisionator()
	{
		if (FIGURA == CUADRAU)
		{
			for (int i = 0; i < cuadraus.size(); i++)
			{
				for (int j = 0; j < bolas.size(); j++)
				{
					if (cuadraus.get(i).intersects(bolas.get(j)))
					{
						bolas.remove(j);
						cuadraus.add(new Cuadrao());
						break;
					}
				}
			}
		}
		else
		{
			for (int i = 0; i < bolas.size(); i++)
			{
				for (int j = 0; j < cuadraus.size(); j++)
				{
					if (bolas.get(i).intersects(cuadraus.get(j)))
					{
						cuadraus.remove(j);
						bolas.add(new Bola());
						break;
					}
				}
			}
		}
		if (FIGURA == CUADRAU && bolas.size() == 1) FIGURA = BOLA;
		if (FIGURA == BOLA && cuadraus.size() == 1) FIGURA = CUADRAU;
	}
}
