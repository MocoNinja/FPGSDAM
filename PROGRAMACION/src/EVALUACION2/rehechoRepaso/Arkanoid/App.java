package EVALUACION2.rehechoRepaso.Arkanoid;

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
	Thread app;
	Graphics ninja;
	Image aux;
	private final int FILAS = 3, COLUMNAS = 10;
	Bola pelota;
	List<Bloque> ladrillos;
	
	public void start()
	{
		pelota = new Bola();
		ladrillos = new ArrayList<Bloque>();
		for (int filas = 0; filas < FILAS; filas++)
		{
			for (int columnas = 0; columnas < COLUMNAS; columnas++)
			{
				ladrillos.add(new Bloque(columnas, filas, filas));
			}
		}
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
		pelota.pinta(aux);
		for (int i = 0; i < ladrillos.size(); i++) ladrillos.get(i).pinta(aux);
	}
	
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(65);
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void elMueve()
	{
		for (int i = 0; i < ladrillos.size(); i++) pelota.mueve(ladrillos.get(i));
	}
}
